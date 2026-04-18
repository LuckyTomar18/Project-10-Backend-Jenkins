package com.rays.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JWTUtil is a utility class for handling JSON Web Tokens (JWT).
 * 
 * It provides functionality to:
 * - Generate JWT tokens
 * - Validate JWT tokens
 * - Extract claims like loginId, userId, and role
 * 
 * It uses HMAC SHA-256 algorithm for signing tokens.
 * 
 * @author Lucky Tomar
 *
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration; // in milliseconds

	private static final ObjectMapper objectMapper = new ObjectMapper();

	// -------------------------
	// Generate JWT token
	// -------------------------

	/**
	 * Generates a JWT token using user details.
	 * 
	 * @param userId user ID
	 * @param loginId user login ID
	 * @param role user role
	 * @return JWT token string
	 * @throws Exception if signing fails
	 */
	public String generateToken(Long userId, String loginId, String role) throws Exception {
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + jwtExpiration;

		// JWT Header
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");

		// JWT Payload (claims)
		Map<String, Object> payload = new HashMap<>();
		payload.put("sub", loginId); // loginId as subject
		payload.put("userId", userId); // numeric user id
		payload.put("role", role); // user role
		payload.put("iat", nowMillis); // issued at
		payload.put("exp", expMillis); // expiration

		String headerBase64 = encodeUrl(objectMapper.writeValueAsString(header));
		String payloadBase64 = encodeUrl(objectMapper.writeValueAsString(payload));
		String signatureBase64 = sign(headerBase64 + "." + payloadBase64, jwtSecret);

		return String.join(".", headerBase64, payloadBase64, signatureBase64);
	}

	// -------------------------
	// Validate JWT token
	// -------------------------

	/**
	 * Validates the JWT token by checking:
	 * - Structure
	 * - Signature
	 * - Subject (loginId)
	 * - Expiration
	 * 
	 * @param token JWT token
	 * @param expectedLoginId expected login ID
	 * @return true if valid
	 * @throws Exception if validation fails
	 */
	public boolean validateToken(String token, String expectedLoginId) throws Exception {
		String[] parts = token.split("\\.");
		if (parts.length != 3) {
			throw new Exception("Invalid JWT token");
		}

		String payloadJson = decode(parts[1]);
		String tokenLoginId = extractField(payloadJson, "sub");
		String expectedSignature = sign(parts[0] + "." + parts[1], jwtSecret);

		if (!expectedSignature.equals(parts[2])) {
			throw new Exception("JWT signature does not match");
		}

		if (!expectedLoginId.equals(tokenLoginId)) {
			throw new Exception("JWT subject (loginId) does not match");
		}

		if (isTokenExpired(payloadJson)) {
			throw new Exception("JWT token has expired");
		}

		return true;
	}

	// -------------------------
	// Extract claims
	// -------------------------

	/**
	 * Extracts loginId (subject) from token.
	 * 
	 * @param token JWT token
	 * @return loginId
	 */
	public String extractLoginId(String token) {
		return extractField(decode(token.split("\\.")[1]), "sub");
	}

	/**
	 * Extracts userId from token.
	 * 
	 * @param token JWT token
	 * @return userId
	 */
	public Long extractUserId(String token) {
		return Long.parseLong(extractField(decode(token.split("\\.")[1]), "userId"));
	}

	/**
	 * Extracts role from token.
	 * 
	 * @param token JWT token
	 * @return role
	 */
	public String extractRole(String token) {
		return extractField(decode(token.split("\\.")[1]), "role");
	}

	// -------------------------
	// Helper methods
	// -------------------------

	/**
	 * Checks if token is expired.
	 * 
	 * @param payloadJson decoded payload JSON
	 * @return true if expired
	 */
	private boolean isTokenExpired(String payloadJson) {
		long exp = Long.parseLong(extractField(payloadJson, "exp"));
		return exp < (System.currentTimeMillis() / 1000);
	}

	/**
	 * Extracts a specific field from JSON payload.
	 * 
	 * @param json JSON string
	 * @param field field name
	 * @return field value
	 */
	private String extractField(String json, String field) {
		try {
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			return String.valueOf(map.get(field));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Signs the JWT using HMAC SHA-256 algorithm.
	 * 
	 * @param data data to sign
	 * @param key secret key
	 * @return signature
	 * @throws Exception if signing fails
	 */
	private String sign(String data, String key) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		return encodeUrl(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * Encodes string to Base64 URL format.
	 * 
	 * @param data input string
	 * @return encoded string
	 */
	private String encodeUrl(String data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Encodes byte array to Base64 URL format.
	 * 
	 * @param data byte array
	 * @return encoded string
	 */
	private String encodeUrl(byte[] data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
	}

	/**
	 * Decodes Base64 URL encoded string.
	 * 
	 * @param data encoded string
	 * @return decoded string
	 */
	private String decode(String data) {
		return new String(Base64.getUrlDecoder().decode(data), StandardCharsets.UTF_8);
	}
}
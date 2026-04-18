package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * UserContext class holds information about the logged-in user.
 * It is used across the application to access user-related details.
 * 
 * @author Lucky Tomar
 *
 */
public class UserContext {

	private Long userId = 0L;
	private String loginId = "root";
	private String name = null;
	private Long roleId = 0L;
	private String roleName = "root";

	private UserDTO userDTO = null;

	/**
	 * Default constructor.
	 */
	public UserContext() {
	}

	/**
	 * Parameterized constructor to initialize from UserDTO.
	 * 
	 * @param dto UserDTO object
	 */
	public UserContext(UserDTO dto) {
		this.userDTO = dto;
		this.userId = dto.getId();
		this.loginId = dto.getLoginId();
		this.name = dto.getName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	/**
	 * Gets user ID.
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets user ID.
	 * 
	 * @param userId user ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets login ID.
	 * 
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets login ID.
	 * 
	 * @param loginId login ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets user name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets user name.
	 * 
	 * @param name user name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets role ID.
	 * 
	 * @return roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets role ID.
	 * 
	 * @param roleId role ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets role name.
	 * 
	 * @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets role name.
	 * 
	 * @param roleName role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets UserDTO object.
	 * 
	 * @return userDTO
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Sets UserDTO object.
	 * 
	 * @param userDTO UserDTO object
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}
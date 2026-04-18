package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * AttachmentDTO represents file attachments stored in the system.
 * 
 * It is mapped to the database table ST_ATTACHMENT.
 * 
 * This DTO handles:
 * - File metadata (name, type, description)
 * - File content stored as byte array (BLOB)
 * - Association with user via userId
 * 
 * It also supports file upload using MultipartFile.
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

	/**
	 * Name of the file
	 */
	@Column(name = "NAME", length = 100)
	protected String name = null;

	/**
	 * MIME type of the file (e.g., image/png, application/pdf)
	 */
	@Column(name = "TYPE", length = 100)
	protected String type = null;

	/**
	 * Description of the file
	 */
	@Column(name = "DESCRIPTION", length = 500)
	protected String description = null;

	/**
	 * ID of the user associated with this attachment
	 */
	@Column(name = "USER_ID")
	protected Long userId = null;

	/**
	 * File content stored as binary large object (BLOB)
	 */
	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	/**
	 * Default constructor
	 */
	public AttachmentDTO() {
	}

	/**
	 * Constructs AttachmentDTO from MultipartFile
	 * 
	 * @param file uploaded file
	 */
	public AttachmentDTO(MultipartFile file) {
		name = file.getOriginalFilename();
		type = file.getContentType();

		try {
			doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets file name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets file name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets file type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets file type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets associated user ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets associated user ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Returns value (not implemented)
	 */
	public String getValue() {
		return null;
	}

	/**
	 * Gets file content
	 */
	public byte[] getDoc() {
		return doc;
	}

	/**
	 * Sets file content
	 */
	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	/**
	 * Returns unique key (not implemented)
	 */
	@Override
	public String getUniqueKey() {
		return null;
	}

	/**
	 * Returns unique value (not implemented)
	 */
	@Override
	public String getUniqueValue() {
		return null;
	}

	/**
	 * Returns label (not implemented)
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name (not implemented)
	 */
	@Override
	public String getTableName() {
		return null;
	}
}
package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentServiceImpl provides service layer implementation
 * for managing Attachment entities.
 * 
 * It extends BaseServiceImpl to inherit common CRUD operations.
 * 
 * This service acts as a bridge between:
 * - Controller layer
 * - DAO layer
 * 
 * Features:
 * - Handles attachment-related business logic
 * - Supports transactional operations
 * - Uses generic service implementation for standard methods
 * 
 * Typically used for:
 * - File upload handling
 * - Image/document storage reference
 * 
 * Note:
 * - Actual DB operations are handled by AttachmentDAOInt
 * - Transactions are managed using @Transactional
 * 
 * @author Lucky Tomar
 *
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentDTO, AttachmentDAOInt>
		implements AttachmentServiceInt {

}
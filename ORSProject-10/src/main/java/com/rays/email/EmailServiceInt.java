package com.rays.email;

/**
 * EmailServiceInt defines the contract for sending emails.
 * 
 * It provides a method to send email messages using
 * an EmailMessage object.
 * 
 * Implementations of this interface handle the actual
 * email sending logic (e.g., using SMTP, JavaMailSender).
 * 
 * @author Lucky Tomar
 *
 */
public interface EmailServiceInt {

	/**
	 * Sends an email using the provided EmailMessage.
	 * 
	 * @param msg EmailMessage containing recipient, subject, and content
	 */
	public void sendMail(EmailMessage msg);
}
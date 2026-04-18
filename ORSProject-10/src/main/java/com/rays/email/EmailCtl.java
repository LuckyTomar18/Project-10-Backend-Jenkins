package com.rays.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmailCtl is a REST controller used to trigger email sending.
 * 
 * It exposes endpoints to send emails using EmailService.
 * This is mainly used for testing or triggering email functionality.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(name = "Mail")
public class EmailCtl {

	@Autowired
	private EmailServiceInt emailService;

	/**
	 * Endpoint to send a test email.
	 * 
	 * @return success message
	 */
	@GetMapping("/send")
	public String sendMail() {

		EmailMessage msg = new EmailMessage();
		msg.setTo("Lucky@gmail.com");
		msg.setSubject("Spring Boot Mail");
		msg.setMessage("Hello, Mail sent successfully!");

		emailService.sendMail(msg);

		return "Mail Sent Successfully";
	}
}
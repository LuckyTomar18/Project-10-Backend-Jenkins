package com.rays.email;

/**
 * EmailMessage is a POJO class used to represent an email.
 * 
 * It contains details such as recipient address, subject,
 * message content, and message type (HTML or TEXT).
 * 
 * This class is used by EmailService to send emails.
 * 
 * @author Lucky Tomar
 *
 */
public class EmailMessage {

    private String to;
    private String subject;
    private String message;

    private int messageType = TEXT_MSG;

    public static final int HTML_MSG = 1;
    public static final int TEXT_MSG = 2;

    /**
     * Default constructor.
     */
    public EmailMessage() {
    }

    /**
     * Parameterized constructor to initialize email details.
     * 
     * @param to recipient email address
     * @param subject email subject
     * @param message email content
     */
    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Gets recipient email address.
     * 
     * @return to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets recipient email address.
     * 
     * @param to recipient email
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets email subject.
     * 
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets email subject.
     * 
     * @param subject email subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets email message content.
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets email message content.
     * 
     * @param message email content
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets message type (HTML or TEXT).
     * 
     * @return messageType
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * Sets message type (HTML or TEXT).
     * 
     * @param messageType type of message
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
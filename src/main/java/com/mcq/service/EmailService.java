package com.mcq.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * @author Omkar Shivadekar
 * Date : 29-Jun-2018
 * Time : 4:37:07 PM
 */
public interface EmailService {
	
	public void sendEmail(SimpleMailMessage email);

}

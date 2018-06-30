package com.mcq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Omkar Shivadekar
 * Date : 29-Jun-2018
 * Time : 4:44:19 PM
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender ;
	
	@Async
	@Override
	public void sendEmail(SimpleMailMessage email) {

		//System.out.println(email);
		mailSender.send(email);
		
	}

}

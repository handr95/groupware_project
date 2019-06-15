package com.dt.J.GC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfig2 {
 
	@Bean
	public static JavaMailSender mailSender(){
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("handr95");
		mailSender.setPassword("dr123456");
		
		return mailSender;
		
	}

}
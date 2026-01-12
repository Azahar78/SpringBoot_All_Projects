package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class AppMailSender {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String from ;
	
	
	public boolean senMail(String to,String subject,String text,Resource file ) throws Exception{
	
		boolean sent =false;
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, file!=null);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			helper.setFrom(from);
			if(file!=null) {
				helper.addAttachment(file.getFilename(),file);
			}
			
			sender.send(mimeMessage);
			
			sent=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
	   
		
		return sent;
	}
}

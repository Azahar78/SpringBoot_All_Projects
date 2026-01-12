package com.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.mail.payload.MailRequest;
import com.mail.service.AppMailSender;

@Component
public class MailRunner implements CommandLineRunner {

	@Autowired
	private AppMailSender mailSender;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Azahar Shaikh_2024
		
		FileSystemResource file = new FileSystemResource("D:\\Azahar Shaikh_2024.pdf");
		
	    MailRequest request = new MailRequest("azahar78685@gmail.com","This Demo Mail","Sending Pdf");
	    
	    boolean isMailSend = mailSender.senMail(request.getTo(), request.getSubject(), request.getText(),file);
	    
	    
	    System.out.println(isMailSend?" Email Sent SuccessFully..":"Something Went Wrong...");
	}

	
}

package com.boot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	
	static int no =0;
	
	 @KafkaListener(topics = "azahar123", groupId = "my-group")
	 

	 
	    public void consume(String message) {
		 
		
		   
	        System.out.println(message+" => recived by consumer  "+no);
	        
	        no++;
	        
	        
	    }
}

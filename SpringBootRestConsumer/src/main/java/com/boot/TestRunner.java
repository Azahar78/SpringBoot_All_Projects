package com.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component 
public class TestRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		
		//String url ="http://localhost:8080/producer/showmsg";
		
		//String url ="http://localhost:8080/producer/path/{i}/{n}";
		
		String url ="http://localhost:8080/producer/user";
		
		
		RestTemplate template = new RestTemplate();
       // ResponseEntity<String> response = template.getForEntity(url,String.class,234,"John");
		
		ResponseEntity<Users> response = template.getForEntity(url,Users.class);
		
		System.out.println(response.getBody().getUserName());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getClass());
	}

}

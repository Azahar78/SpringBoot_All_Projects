package com.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		// 1. Create Url
		
		String url ="http://localhost:8080/producer/create";
		
		// 2. create Header
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// 3. Combine both body and header
		

		
		RestTemplate rt = new RestTemplate();
		
		
		
		String body = "{\"userId\": 7799,\"userName\": \"Azahar Shaikh\",\"userAddress\": \"Banglore\"}";
 
		HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
		
//		ResponseEntity<Users> response = rt.postForEntity(url,httpEntity, Users.class);
		
		ResponseEntity<Users> response = rt.exchange(url,HttpMethod.POST, httpEntity,Users.class);
		
		
		
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getClass());
	}

}

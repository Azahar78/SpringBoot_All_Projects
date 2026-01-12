package com.boot.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class CartConsumer {

	// By Using DiscoveryClient Interface
	
	//@Autowired
	private DiscoveryClient client;
	
	public String getCartResponse() {                          
		
		List<ServiceInstance> instances = client.getInstances("CART-SERVICE");
		
		ServiceInstance serviceInstance = instances.get(0);
		
		URI uri = serviceInstance.getUri();
		
		String url =uri+"/cart/show";
		RestTemplate rt = new RestTemplate();
		
		// ResponseEntity<String> response = rt.getForEntity(url,String.class);
		
		ResponseEntity<String> response = rt.exchange(url,HttpMethod.GET,null,String.class);
		
		return response.getBody();
	}
	
}

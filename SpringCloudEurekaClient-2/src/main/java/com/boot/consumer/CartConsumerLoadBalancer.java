package com.boot.consumer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class CartConsumerLoadBalancer {

	//@Autowired
	private LoadBalancerClient client;
	
	public String getCartMsg() {
		
		ServiceInstance serviceInstance = client.choose("CART-SERVICE");
		
		String url=serviceInstance.getUri()+"/cart/show";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> responnse = template.getForEntity(url,String.class);
		
		return responnse.getBody();
	}
}

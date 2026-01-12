package com.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.consumer.CartConsumer;
import com.boot.consumer.CartConsumerFeign;
import com.boot.consumer.CartConsumerLoadBalancer;
import com.boot.entity.CartDetails;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/order")
public class ProductRestController {

	// @Autowired
	// private CartConsumer consumer;
	
	@Autowired
	private CartConsumerFeign consumer;

//	@Autowired
//	private CartConsumerLoadBalancer consumerLoadBalancer;
	
	@GetMapping("/info")
	public ResponseEntity<String> getOrderInfo(){
		
	//	String cartResponse = consumer.getCartResponse();
		
		String cartResponse = consumer.showCartMsg().getBody();
		
		return ResponseEntity.ok("Order service : "+cartResponse);
	}
	
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> getCartOrderById(@PathVariable Integer id ){
		
		ResponseEntity<String> response = consumer.getCartById(id);
		
		return response;
	}
	
	//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
	
	@PostMapping("/post")
	public ResponseEntity<CartDetails> postOrderCart(@RequestBody CartDetails cart){
		
		ResponseEntity<CartDetails> response = consumer.postCart(cart);
		
		return new ResponseEntity<CartDetails>(response.getBody(),HttpStatus.OK);
	}
}

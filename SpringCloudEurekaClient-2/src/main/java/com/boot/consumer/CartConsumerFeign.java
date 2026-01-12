package com.boot.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.entity.CartDetails;

@FeignClient("CART-SERVICE")
public interface CartConsumerFeign {

	@GetMapping("/cart/show")
	public ResponseEntity<String> showCartMsg();
	
	@GetMapping("/cart/fetch/{ids}")
	public ResponseEntity<String> getCartById(@PathVariable Integer ids);
	
	@PostMapping("/cart/post")
	public ResponseEntity<CartDetails> postCart(@RequestBody CartDetails cart );
}

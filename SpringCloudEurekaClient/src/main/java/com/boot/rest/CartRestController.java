package com.boot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Cart;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Value("${server.port}")
	String port;
	
	@Value("${my.app}")
	String title;

	@GetMapping("/show")
	public ResponseEntity<String> showMsg(){
		return new ResponseEntity<String>("Welcome To Cart Service :: "+port+" :: "+title,HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> getCartById(@PathVariable Integer id){
		return new ResponseEntity<String>(" Cart Details : "+new Cart(id,"TEST",567.00),HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Cart> postCart(@RequestBody Cart cart ){
		return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
	}
}

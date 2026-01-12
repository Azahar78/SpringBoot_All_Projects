package com.boot.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	@GetMapping("/guest")
	public ResponseEntity<String> showMsg(){
		return ResponseEntity.ok("Welcome Guest");
	}
	
	
	@GetMapping("/user")
	public ResponseEntity<String> showUser(){
		return ResponseEntity.ok("Welcome User : ");
	}
	
	
	@GetMapping("/admin")
	public ResponseEntity<String> showAdmin(){
		return ResponseEntity.ok("Welcome Admin : ");
	}
}

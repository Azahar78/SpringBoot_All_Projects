package com.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class DemoRestController {

	@GetMapping("/fetch")
	public ResponseEntity<String> fetch(){
		return new ResponseEntity<>(" Get Operation Perform",HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<String> create(){
		return new ResponseEntity<>(" Post Operation Perform",HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> update(){
		return new ResponseEntity<>(" Post Operation Perform",HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> remove(){
	
		return new ResponseEntity<>(" Delete Operation Perform",HttpStatus.OK);
	
	}
	
	
}

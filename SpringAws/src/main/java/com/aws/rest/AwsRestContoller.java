package com.aws.rest;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsRestContoller {

	@GetMapping("/get/{name}")
	public ResponseEntity<String> getMessage(@PathVariable String name){
		return ResponseEntity.ok("Welcome Mrs/Ms : "+name+ " "+LocalDate.now());
	}
}

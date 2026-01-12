package com.boot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Users;

@RestController
@RequestMapping("/producer")
public class ProducerRestController {

	@GetMapping("/path/{id}/{name}")
	public ResponseEntity<String> pathVar(@PathVariable Integer id, @PathVariable String name) {

		return ResponseEntity.ok("Id : "+id+" Name : "+name);
	}

	@GetMapping("/showmsg")
	public ResponseEntity<String> showMsg() {
		return new ResponseEntity<String>("This Message From Producer...", HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<Users> getUser(){
		return ResponseEntity.ok(new Users(500,"Willam","Mumbai"));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Users> postUser(@RequestBody Users users ){
		System.out.println(users);
		return ResponseEntity.ok(users);
	}
	
}

package com.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/api/user")
public class UserRestController {

	@Autowired
	private IUserService service;
	
	
	@PostMapping("/post")
	public ResponseEntity<String> postUser(@RequestBody @Valid User user){
		Integer id = service.createUser(user);
		return new ResponseEntity<String>(String.format("User Create with Id : %d",id),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/put")
	public ResponseEntity<String> modifyUser(@RequestBody @Valid User user){
		
		System.out.println(user);
		
		String message = service.updateUser(user);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED );
	}

	@GetMapping("/fetch/{id}")
    public ResponseEntity<User> fetchUser(@PathVariable Integer id){
		
		ResponseEntity<User> response = null;
		
		/*
		 * try {
		 * 
		 * User user = service.getUserById(id); response= new
		 * ResponseEntity<User>(user,HttpStatus.CREATED);
		 * 
		 * } catch (UserNotFoundException e) { e.printStackTrace(); throw e; }
		 */
		
		User user = service.getUserById(id);
		response= new ResponseEntity<User>(user,HttpStatus.OK);
		
    	return response;
    }


	@GetMapping("/all")
	public ResponseEntity<List<User>> fetchAllUsers(){
		return new ResponseEntity<List<User>>(service.getAllUser(),HttpStatus.OK);
	}

	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeUser(@PathVariable Integer id){
		String message = service.deleteUserById(id);
		return ResponseEntity.ok(message);
	}


	
}

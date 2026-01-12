package com.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.UserDetail;
import com.boot.service.IUserService;

@RestController
@RequestMapping("/auth")
public class UseRestController {
	
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/public")
	public ResponseEntity<String> publicMsg(){
		return ResponseEntity.ok("Welcom Public");
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("Welcom User");
	}
	
	
	@GetMapping("/admin")
	public ResponseEntity<String> publicAdmin(){
		return ResponseEntity.ok("Welcom admin");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDetail userDetail){
		
		try {
			Authentication authenticate = manager
		   .authenticate(
				   new UsernamePasswordAuthenticationToken(userDetail.getUserName(),
				   userDetail.getUserPwd())
				   );
			
			UserDetails userByUsername = userDetailsService.loadUserByUsername(userDetail.getUserName());
			
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			
			return ResponseEntity.ok(" User Login "+userByUsername.getUsername());
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("invalid Credenitial");
		}
		
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDetail detail){
		
		Integer id = service.createUser(detail);
		
		if(id>0) {
			return ResponseEntity.ok(" User Created ID : "+id);
		}
		else {
			return ResponseEntity.ok("Username Alerday taken");
		}
	}
	
	   
}

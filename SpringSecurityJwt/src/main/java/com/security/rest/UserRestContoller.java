package com.security.rest;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.security.entity.UserInfo;
import com.security.payload.TokenRequest;
import com.security.payload.TokenResponse;
import com.security.service.IUserService;
import com.security.utils.JwtUtils;

@RestController
@RequestMapping("/auth")
public class UserRestContoller {

	@Autowired
	private IUserService service;
	
//	@Autowired
//	private AuthenticationManager manager;
	
//	@Autowired
//	private JwtUtils utils;
	
	@PostMapping("/post")
	public ResponseEntity<String> postUser(@RequestBody UserInfo info){
		
		Integer id = service.registorUser(info);
		
		return ResponseEntity.ok(String.format("User Register with %d Successfully..",id));
	}
	
	/*
	 * @GetMapping("/post") public ResponseEntity<?> postUser(){
	 * 
	 * //Integer id = service.registorUser(info);
	 * 
	 * return ResponseEntity.ok(String.format("User Register with Successfully.."));
	 * }
	 */
	
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> loginUser(@RequestBody TokenRequest tokenRequest){
		
		/*
		Authentication authenticate = manager
		.authenticate(new UsernamePasswordAuthenticationToken(tokenRequest.getUserName(),tokenRequest.getPassword()));
		
		String token = utils.generateToken(tokenRequest.getUserName());
		
		*/
		
		TokenResponse tokenResponse = service.loginUser(tokenRequest);
		
		return ResponseEntity.ok(tokenResponse);
	}
	
	
	@GetMapping("/welcome")
	public ResponseEntity<String> showMsg(Principal p){
		return ResponseEntity.ok(" Welcome MR/MS : "+p.getName());
	}
}

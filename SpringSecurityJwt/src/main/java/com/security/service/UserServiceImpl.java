package com.security.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.UserInfo;
import com.security.payload.TokenRequest;
import com.security.payload.TokenResponse;
import com.security.repo.UserRepo;
import com.security.utils.JwtUtils;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtils utils;

	@Override
	public Integer registorUser(UserInfo userInfo) {

		String encodePwd = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(encodePwd);
		UserInfo user = repo.save(userInfo);
		return user.getId();
	}

	@Override
	public TokenResponse loginUser(TokenRequest tokenRequest) {
		
		Authentication authenticate = manager
				.authenticate(new UsernamePasswordAuthenticationToken(tokenRequest.getUserName(),tokenRequest.getPassword()));
				
				String token = utils.generateToken(tokenRequest.getUserName());
		
		return new TokenResponse(token,LocalDate.now());
	}

	@Override
	public List<UserInfo> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}


}

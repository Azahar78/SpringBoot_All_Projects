package com.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.UserInfo;
import com.security.repo.UserRepo;

@Service 
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = repo.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with '" + username + "'"));

		List<GrantedAuthority> list = user.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles))
				.collect(Collectors.toList());

		return new User(user.getUserName(), user.getPassword(), list);
	}

}

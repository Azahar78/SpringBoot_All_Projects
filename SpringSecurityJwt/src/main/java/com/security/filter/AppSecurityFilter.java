package com.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.service.CustomUserDetailsService;
import com.security.service.UserServiceImpl;
import com.security.utils.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AppSecurityFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private CustomUserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
	  final	String authorizationHeader = request.getHeader("Authorization");
	  
	  String username =null;
	  String token =null;
		
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
			
			  token  = authorizationHeader.substring(7);
			  try {
				
				  username = utils.extractUsername(token);
				  
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token Expired ");
			}catch(Exception e) {
				System.out.println("Error extracting username for jwt..");
			}
			
		}
		
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		   
			UserDetails userDetails = service.loadUserByUsername(username);
			
			if(utils.ValidateToken(token, username)) {
				UsernamePasswordAuthenticationToken authenticationToken 
				     = new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
				
				authenticationToken.setDetails(new WebAuthenticationDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}

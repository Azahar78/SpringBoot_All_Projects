package com.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private String secret = "azahar@dghhbbkffff988";

	// Note subject = username

	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public Date extractExpiration(String token) {
		return getClaims(token).getExpiration();
	}
	
	

	private Claims getClaims(String token) {

		try {

			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		} catch (ExpiredJwtException e) {

			throw new RuntimeException(" Token has expired.");
		} catch (Exception e) {

			throw new RuntimeException("Error Parsing Token");
		}

	}
	
	
	public Boolean isTokenExpire(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean ValidateToken(String token,String username) {
		final String name =extractUsername(token);
		return (name.equals(username)&&!isTokenExpire(token));
		
	} 

	public String generateToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		return generateToken(claims, username);
	}

	private String generateToken(Map<String, Object> claims, String subjectt) {

		String token = Jwts.builder().setClaims(claims).setSubject(subjectt).setIssuer("Jwt Security Test")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256, secret).compact();

		return token;
	}
	
	
	
}

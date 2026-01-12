package com.jwt.my_jwt_app;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtDemo {

	public static void main(String[] args) {
		
		String secretKey = "MyScretKey";
		
		String token = Jwts.builder()
		.setId("3245566")
		.setSubject("MyJwt")
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(2)))
		.setIssuer("Azahar")
		.signWith(SignatureAlgorithm.HS256, secretKey)
		.compact();
		
		
		System.out.println(token);
		
		System.out.println("===================================***********================================");
		
		Claims claims = Jwts.parser().setSigningKey(secretKey)
		.parseClaimsJws(token).getBody();
		
		System.out.println(claims);
		System.out.println(claims.getIssuer());
		System.out.println(claims.getSubject());
	    System.out.println(claims.getExpiration().getSeconds());
	}
	
}

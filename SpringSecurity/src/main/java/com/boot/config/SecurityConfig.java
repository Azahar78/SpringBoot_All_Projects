package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.boot.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder managerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
			
		managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		return managerBuilder.build();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(c-> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
		http.authorizeHttpRequests(
				auth->auth
				
				
				.requestMatchers("/auth/public/**","/auth/login","/auth/signup").permitAll()
				.requestMatchers("/auth/user/**").hasAnyAuthority("USER")
                .requestMatchers("/auth/admin/**").hasAnyAuthority("USER","ADMIN")				
		 
		    )
		//.exceptionHandling(e->e.authenticationEntryPoint(null))
		//.addFilterBefore(null, UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

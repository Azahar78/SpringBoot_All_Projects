package com.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {

	@Bean
	public Company company() {
		
		Company cm = new Company();
		
		cm.setcName("IndianDereamers");
		cm.setCaddress("Bhusawal");
		
		return cm;
	}
}

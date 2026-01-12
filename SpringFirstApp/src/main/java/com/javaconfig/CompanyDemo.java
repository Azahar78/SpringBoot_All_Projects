package com.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyDemo {

	public static void main(String[] args) {
		
		ApplicationContext ac =new AnnotationConfigApplicationContext(CompanyConfig.class);
	
		Company company = ac.getBean("company",Company.class);
		
		System.out.println(company);
	}
}

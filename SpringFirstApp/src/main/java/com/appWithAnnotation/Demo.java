package com.appWithAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext();
		ac.scan("com.appWithAnnotation");
		ac.refresh();
		User user = ac.getBean("u",User.class);
		
		/*
		 * user.setAddress("Mumbai"); user.setAge(30); user.setName("John");
		 */
		
		System.out.println(user);
	}
}

package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac= new ClassPathXmlApplicationContext("config.xml");
		
		Person p =(Person)ac.getBean("person");
		
		System.out.println(p);
		
		
		System.out.println("===============================");
		
		Employee emp = (Employee)ac.getBean("employee");
		
		System.out.println(emp);
	}
}

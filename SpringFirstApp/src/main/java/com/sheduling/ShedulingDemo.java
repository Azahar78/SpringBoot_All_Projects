package com.sheduling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShedulingDemo {

	public static void main(String[] args) {
	  ApplicationContext ac= new AnnotationConfigApplicationContext(ShedulingConfig.class);
	  
	  ShedulingService service = ac.getBean("sos",ShedulingService.class);
	  
	  
	}
}

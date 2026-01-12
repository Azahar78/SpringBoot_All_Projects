package com.withProps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropsDemo {

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(Myconfig.class);
		  Employee employee = ac.getBean("employee",Employee.class);
		  System.out.println(employee);
	}
}

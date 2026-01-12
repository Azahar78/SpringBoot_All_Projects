package com.withProps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@Value("${my.name}")
	private String name;
	
	@Value("${my.job}")
	private String job;
	
	@Value("${my.age}")
	private int age;
	
	@Value("${my.address}")
	private String address;
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", job=" + job + ", age=" + age +", address=" + address + "]";
	}
	
	
}

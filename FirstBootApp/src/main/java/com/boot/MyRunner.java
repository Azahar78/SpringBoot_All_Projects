package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner{

	@Autowired
	private DbCon con;
	
	@Autowired
	private Person person;
	
	@Override
	public void run(String... args) throws Exception {
		
		person.setName("aghjj");
		person.setAddress("mum");
		person.setAge(34);
		
		System.out.println(con);
		
		System.out.println("=============================================================");
		
		System.out.println(person);
	}
}

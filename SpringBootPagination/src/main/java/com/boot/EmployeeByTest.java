package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.repo.EmployeeRepo;

//@Component
public class EmployeeByTest implements CommandLineRunner {

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 repo.findByDeptAndName("HR","Paul Brown").forEach(System.out::println);;
		
		 System.out.println("==================================");
		
		// repo.findBydept("HR").forEach(System.out::println);;
		
		repo.findByNameLike("J%").forEach(System.out::println);
		
		System.out.println("=======================================");
		
		repo.findByDeptLike("D%").forEach(System.out::println);
	}
}

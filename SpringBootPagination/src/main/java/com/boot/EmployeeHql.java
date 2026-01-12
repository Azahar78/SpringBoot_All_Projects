package com.boot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.repo.EmployeeRepo;

@Component 
public class EmployeeHql implements CommandLineRunner{

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		repo.getAllEmployee().forEach(System.out::println);
		
		System.out.println("================================");
		
		repo.getEmpName().forEach(System.out::println);
		
		System.out.println("=================================");
		
		List<Object[]> nameAndDept = repo.getEmpNameAndDept();
		
		nameAndDept.stream().map(obj->" Name : "+obj[0]+ " Department : "+obj[1]).forEach(System.out::println);
		
		System.out.println("==================================");
		
		Optional<String> empNameById = repo.getEmpNameById(1);
		
		System.out.println(empNameById.get());
		
		System.out.println("======================================");
		
		System.out.println(repo.getEmpById(11).get());
		
		System.out.println("====================================");
		
		repo.getEmpByDept().stream().map(emp->" dept : "+emp[0]+" dept count : "+emp[1])
		                   .forEach(System.out::println);
		
		
	}

}

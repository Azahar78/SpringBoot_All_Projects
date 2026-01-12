package com.boot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.entity.Department;
import com.boot.entity.Employees;
import com.boot.repo.DepartmentRepo;
import com.boot.repo.EmployeeRepo;

@Component
public class EmpDeptTest implements CommandLineRunner{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Department department = new Department(100,"Devops","b122");
		//departmentRepo.save(department);
		
		
		Employees employees1 = new Employees(1,"John","UK",35,department);
		Employees employees2 = new Employees(3,"Abdul","Dubai",25,department);
		Employees employees3 = new Employees(2,"Devid","Amdon",45,department);
		
	//	employeeRepo.save(employees1);
	//	employeeRepo.save(employees2);
	//	employeeRepo.save(employees3);
	
		employeeRepo.deleteById(2);
		
		
		employeeRepo.findAll().forEach(System.out::println);
		

	}

}

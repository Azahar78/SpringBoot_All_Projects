package com.boot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.entity.Student;
import com.boot.repo.StudentRepo;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Student Repo ..");

		/*
		 * Student student = new Student(); student.setSId(1); student.setSName("John");
		 * student.setSAddress("Pune");
		 * 
		 * Student save = repo.save(student);
		 */

		Optional<Student> id = repo.findById(1);
		
		

		System.out.println(id.get().getSName());
		
	//	System.out.println(save);

	}

}

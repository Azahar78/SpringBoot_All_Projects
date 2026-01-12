package com.boot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.entity.Course;
import com.boot.entity.Trainee;
import com.boot.repo.CourseRepo;
import com.boot.repo.TraineeRepo;

@Component
public class Test implements CommandLineRunner {

	@Autowired
	private TraineeRepo traineeRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public void run(String... args) throws Exception {

		Course course1 = new Course(12, "Java", 300.9);
		Course course2 = new Course(23, "React js", 250.0);

		courseRepo.saveAll(Arrays.asList(course1, course2));

		Trainee t1 = new Trainee(100, "John", "jhon@gmail.com", Arrays.asList(course1, course2));
		Trainee t2 = new Trainee(200, "william", "william@gmail.com", Arrays.asList(course1, course2));
         
		traineeRepo.saveAll(Arrays.asList(t1,t2));

	}
}

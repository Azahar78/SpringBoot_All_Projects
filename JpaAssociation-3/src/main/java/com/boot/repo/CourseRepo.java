package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}

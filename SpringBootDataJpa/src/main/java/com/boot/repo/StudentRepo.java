package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}

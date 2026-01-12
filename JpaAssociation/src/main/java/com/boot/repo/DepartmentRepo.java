package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}

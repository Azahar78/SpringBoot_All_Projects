package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Employees;

public interface EmployeeRepo extends JpaRepository<Employees, Integer>{

}

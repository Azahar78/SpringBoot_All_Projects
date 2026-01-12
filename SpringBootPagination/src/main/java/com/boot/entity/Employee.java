package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@Column(name="eId")
	private int id;
	
	@Column(name = "eName")
    private String name;
	
	@Column(name = "eSalary")
    private double salary;
	
	@Column(name = "eDept")
	@NonNull
    private String dept;
}

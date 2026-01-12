package com.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Employee_info")
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

	@Id
	private Integer empId;
	private String empName;
	private String empAddress;
	private Integer empAge;
	
	@ManyToOne
	private Department department;
	
}

package com.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Department_info")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	private Integer code;
	private String deptName;
	private String deptBatch;
	
}

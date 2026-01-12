package com.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	private int sId;
	private String sName;
	private String sAddress;
	
}

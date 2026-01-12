package com.rest.entity;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private Integer personId;
	private String personName;
	private String personColour;
	
	private List<String> address;
	
	
	
	private Set<Roles> roles;
}

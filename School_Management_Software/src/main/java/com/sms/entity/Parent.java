package com.sms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer parentId;
	    private String emailId;
	    private String firstName;
	    private String lastName;
	    private String mobileNumber;

	    @OneToMany(mappedBy = "parents",cascade = CascadeType.ALL,orphanRemoval = true)
	    private List<Student> students;
}

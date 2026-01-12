package com.boot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {

	@Id
	private Integer traineeId;
	private String traineeName;
	private String traineeEmail;
	
	@ManyToMany()
	@JoinTable(name = "trainee_course",
	           joinColumns = @JoinColumn(name="traineeFk"),
	           inverseJoinColumns = @JoinColumn(name="courseFk")
	           
			 )
	private List<Course> course;
	
}

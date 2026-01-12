package com.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer gradeId;
	    private String grade;
	    private String subject;
	    private String term;

	    @ManyToOne
	    @JoinColumn(name = "classes_id")
	    private Classes classes;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;
}

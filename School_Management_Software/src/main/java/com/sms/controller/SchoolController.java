package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.School;
import com.sms.service.SchoolService;

@RestController
@RequestMapping("/v1/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	 
	
	@PostMapping("/post_school")
	public ResponseEntity<?> addSchool(@RequestBody School school){
		
		Boolean schooln = schoolService.createSchool(school);
		
		return schooln ? ResponseEntity.ok("School Created.."):ResponseEntity.ok("Something Went Wrong..");
	}
}

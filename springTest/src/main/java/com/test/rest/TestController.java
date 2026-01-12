package com.test.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.TestEntity;

@RestController
@RequestMapping("v1/api")
public class TestController {

	@GetMapping("msg")
	public ResponseEntity<String> getmessage(){
		
	   TestEntity entity = new TestEntity();
	   
	   entity.setId(100);
	   entity.setTest("sts test");
		
		return ResponseEntity.ok("Hello user"+entity.getId()+" "+entity.getTest());
	}
}

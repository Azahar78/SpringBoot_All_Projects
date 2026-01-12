package com.rest;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Person;
import com.rest.entity.Product;
import com.rest.entity.Roles;

@RestController
@RequestMapping("/v1/api/person")
public class PersonRestController {

	@PostMapping("/post")
	public ResponseEntity<Product> postProduct(@RequestBody Product product ){
		System.out.println(product.getProductId()+" : Name => "+product.getProductName()+" : Price => "+product.getProductPrice());
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Person> getPersonInfo(){
		
		return new ResponseEntity<Person>(new Person(12,"John","Fair",
				 Arrays.asList("Lundon","Dubai","Bangkok"),
				 new LinkedHashSet<>(Arrays.asList(new Roles(222,"Admin"),new Roles(333,"Guest"))) 
				),HttpStatus.OK);
	}
}

package com.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Product;
import com.boot.exception.ProductNotFoundException;
import com.boot.service.ProductService;

@RestController
public class ProductRestContoller {

	@Autowired
	private ProductService service;
	
	@GetMapping("/fetch/{pid}")
	public ResponseEntity<Product> getProdcut(@PathVariable Integer pid){
		
		ResponseEntity<Product> response =null;
		
		try {
			
			Product product = service.getProductById(pid);
			response= new ResponseEntity<Product>(product,HttpStatus.OK);
			
		}
		catch(ProductNotFoundException pnf) {
			pnf.getStackTrace();
			throw pnf;
		}
		
       return response;		
		
	}
}

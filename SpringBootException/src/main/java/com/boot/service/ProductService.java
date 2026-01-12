package com.boot.service;

import org.springframework.stereotype.Service;

import com.boot.entity.Product;
import com.boot.exception.ProductNotFoundException;

@Service
public class ProductService {

	public Product getProductById(Integer id) {
		
	
		
		if(id ==100) {
		  
			return new Product(id,"Mobile",23);
		}
		else {
			throw new ProductNotFoundException(" Product Not Found : "+id+" ");
		}
		
		
	}
}

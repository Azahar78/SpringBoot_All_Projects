package com.boot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private Double productPrice;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "productFk")
	private List<Model> model;
	
}

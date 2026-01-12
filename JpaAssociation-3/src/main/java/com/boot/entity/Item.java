package com.boot.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(generator = "test")
	@GenericGenerator(name = "test",strategy = "com.boot.MyGeneratedId")
	private String itemId;
	private String itemName;
	private Integer itemQty;
	
}

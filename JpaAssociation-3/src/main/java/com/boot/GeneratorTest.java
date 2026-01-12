package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.entity.Item;
import com.boot.repo.ItemRepo;

@Component
public class GeneratorTest implements CommandLineRunner{

	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Item item = new Item();
		item.setItemName("Laptop");
		item.setItemQty(5);
		
		itemRepo.save(item);
	}

}

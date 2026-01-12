package com.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.entity.Model;
import com.boot.entity.Product;
import com.boot.repo.ModelRepo;
import com.boot.repo.ProductRepo;

@Component
public class ProductTest implements CommandLineRunner {

	@Autowired
	private ProductRepo pRepo;
	
	@Autowired
	private ModelRepo mRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Model model = new Model(111,"M111","Red"); Model model1 = new
		 * Model(222,"M222","Green"); Model model2 = new Model(333,"M333","Blue"); Model
		 * model3 = new Model(444,"M444","Black");
		 */
		
		/*
		 * List<Model> mList = Arrays.asList(model,model1,model2,model3);
		 * 
		 * mRepo.saveAll(mList);
		 * 
		 * 
		 * Product product = new
		 * Product(10,"Mobile",5566.00,Arrays.asList(model,model2)); Product product1 =
		 * new Product(20,"Laptop",8006.00,Arrays.asList(model1,model3));
		 * 
		 * pRepo.saveAll(Arrays.asList(product,product1));
		 */
		
		pRepo.findAll().forEach(System.out::println);
		
//		Product product = pRepo.findById(20).orElseThrow(()->new RuntimeException("Product Not Found.."));
//		
//		System.out.println(product);
		
		}
}

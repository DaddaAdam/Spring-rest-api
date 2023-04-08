package com.management;

import com.management.entities.Product;
import com.management.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class MainApplicationApplicationTests {
	@Autowired
	ProductRepository Repository;

	@Test
	public void TestCreateProduct(){
		Product p = new Product("Ordinateur", 6000.0, new Date());
		Repository.save(p);
	}

	@Test
	public void TestFindAll(){
		ArrayList<Product> products = (ArrayList<Product>) Repository.findAll();
		for (Product product:
			 products) {
			System.out.println(product);
		}
	}

	@Test
	public void FindByID(){
		Product product = Repository.findById(1L).get();
		System.out.println(product);
	}

	@Test
	void contextLoads() {
	}
}

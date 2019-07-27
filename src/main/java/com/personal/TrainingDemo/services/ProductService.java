package com.personal.TrainingDemo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.personal.TrainingDemo.beans.Product;

@Service
public class ProductService {

	private List<Product> productsList = new ArrayList<>(Arrays.asList(new Product("3"), 
																		new Product("2"), 
																		new Product("1")));

	public List<Product> getAllProducts() {
		return productsList;
	}

	public Product getProduct(String id) {
		if (productsList != null) {
			Optional<Product> optional = productsList.stream().filter(product -> product.getId().equals(id))
					.findFirst();
			return optional.isPresent() ? optional.get() : null;
		}
		return null;
	}

	public int addProduct(Product product) {
		if(getProduct(product.getId()) == null) {
			productsList.add(product);
			return 0;
		} else {
			return 1;
		}
	}

}

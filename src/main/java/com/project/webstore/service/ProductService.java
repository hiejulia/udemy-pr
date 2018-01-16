package com.project.webstore.service;

import java.util.List;
import java.util.Map;

import com.project.webstore.domain.Product;
/**
 * PRODUCT SERVICE
 * @author hien
 *
 */
public interface ProductService {

	void updateAllProductCourse();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	Product getProductById(String productID);
	
	void addProduct(Product product);
	
	List<Product> getProductsByTeacher(String teacher);
}

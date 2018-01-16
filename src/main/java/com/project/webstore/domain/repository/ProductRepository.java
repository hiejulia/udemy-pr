package com.project.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.project.webstore.domain.Product;
/**
 * PRODUCT REPOSITORY
 * @author hien
 *
 */
public interface ProductRepository {

	List <Product> getAllProducts();
	
//	void updateStock(String productId, long noOfUnits);
	
	// update product course 
	void updateProductCourse(String productId, long seatAvailable);
	
	List<Product> getProductsByCategory(String category);
	 
	List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	 
	Product getProductById(String productID);
	
	void addProduct(Product product);
	
	List<Product> getProductsByTeacher(String teacher);
}

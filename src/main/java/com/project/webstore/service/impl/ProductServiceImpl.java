package com.project.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.webstore.domain.Product;
import com.project.webstore.domain.repository.ProductRepository;
import com.project.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

   @Autowired
   private ProductRepository productRepository;
  
   
   // check lai
   @Override 
   public void updateAllProductCourse() {
	   List<Product> allProducts = productRepository.getAllProducts();
	   for(Product p:allProducts) {
		   if(p.getSeatAvailable()>0) {
			   productRepository.updateProductCourse(p.getProductId(), p.getSeatAvailable());
		   }
	   }
   }
   
   @Override
   public List<Product> getAllProducts() {
         return productRepository.getAllProducts();
   }
   
   public List<Product> getProductsByCategory(String category) {
	   return productRepository.getProductsByCategory(category);
	}  
   
   public List<Product> getProductsByTeacher(String teacher){
	   return productRepository.getProductsByTeacher(teacher);
   }
   
   public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
	      return productRepository.getProductsByFilter(filterParams);
	}
   
   @Override
   public Product getProductById(String productID) {
      return productRepository.getProductById(productID);
   }
   
   @Override
   public void addProduct(Product product) {
      productRepository.addProduct(product);
   }

}

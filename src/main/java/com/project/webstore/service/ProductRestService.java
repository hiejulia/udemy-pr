package com.project.webstore.service;

import com.project.webstore.domain.Product;
import com.project.webstore.dto.ProductCourseDto;

public interface ProductRestService {
	Product read(String productId);
	
	void create(ProductCourseDto productDto);
	
	void update(String productId, ProductCourseDto productCourseDto);
	
	void delete(String productId);
	
	

}

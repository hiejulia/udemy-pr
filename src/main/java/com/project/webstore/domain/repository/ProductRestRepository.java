package com.project.webstore.domain.repository;

import com.project.webstore.domain.Product;
import com.project.webstore.dto.ProductCourseDto;

public interface ProductRestRepository {
	void create(ProductCourseDto productCourseDto);
	
	Product read(String id);
	
	void update(String id,ProductCourseDto p);
	
	
	
	

}

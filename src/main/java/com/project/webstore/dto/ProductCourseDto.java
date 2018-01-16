package com.project.webstore.dto;

import java.io.Serializable;

public class ProductCourseDto implements Serializable{
	private static final long serialVersionUID = -2017182726290898588L;
	
	private String productId;
	private String name;
	private String teacher;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	

}

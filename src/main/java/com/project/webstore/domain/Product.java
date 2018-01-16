package com.project.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.webstore.validator.ProductId;

@XmlRootElement
public class Product implements Serializable {
	private static final long serialVersionUID = 3678107792576131001L;

	@Pattern(regexp="P[1-9]+", message="{Pattern.Product.productId.validation}")
	@ProductId 
	private String productId;
	
	@Size(min=4, max=50, message="{Size.Product.name.validation}")
	private String name;
	
	@Min(value=0, message="{Min.Product.unitPrice.validation}")
	@Digits(integer=8, fraction=2, message="{Digits.Product.unitPrice.validation}")
//	@NotNull(message= "{NotNull.Product.unitPrice.validation}")
	private BigDecimal price;
	
	private String description;
	
	private String teacher;
	
	private String category;
	
	private long numOfSeats;
	
	private long seatAvailable;
	
	private boolean discontinued;
	
	private String condition;
	
	@JsonIgnore
	private MultipartFile productImage;
	// product pdf
//	@JsonIgnore
//	private MultipartFile productPdf;

	public Product() {
		super();
	}

	
	
	
	
	public Product(String productId, String name, BigDecimal price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}





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





	public BigDecimal getPrice() {
		return price;
	}





	public void setPrice(BigDecimal price) {
		this.price = price;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getTeacher() {
		return teacher;
	}





	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public long getNumOfSeats() {
		return numOfSeats;
	}





	public void setNumOfSeats(long numOfSeats) {
		this.numOfSeats = numOfSeats;
	}





	public long getSeatAvailable() {
		return seatAvailable;
	}





	public void setSeatAvailable(long seatAvailable) {
		this.seatAvailable = seatAvailable;
	}





	public boolean isDiscontinued() {
		return discontinued;
	}





	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}





	public String getCondition() {
		return condition;
	}





	public void setCondition(String condition) {
		this.condition = condition;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
}

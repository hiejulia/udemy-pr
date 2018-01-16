package com.project.webstore.domain;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CustomerTest {
	
	private Customer customer;
	
	@Before 
	public void setup() {
//		customer = new Customer();
	}
	
	@Test 
	public void assertCustomerName() {
		Customer testCustomer = new Customer(600851475143L,"Hien");
		
		Assert.assertEquals("Hien",testCustomer.getName() );
		
		
	}

}

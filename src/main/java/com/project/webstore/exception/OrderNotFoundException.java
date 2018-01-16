package com.project.webstore.exception;

public class OrderNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -694354957L;
	
	private long orderId;
	
	public OrderNotFoundException(long orderId) {
		this.orderId = orderId;
		
	}
	
	public long getOrderId() {
		return orderId;
	}

}

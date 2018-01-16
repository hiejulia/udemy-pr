package com.project.webstore.exception;

public class InvalidShippingDetailException extends RuntimeException {
	private static final long serialVersionUID = -51920415630333L;
	
	public long shippingDetailId;
	
	public InvalidShippingDetailException(long id) {
		this.shippingDetailId = id;
	}
	
	public long getShippingDetailId() {
		return shippingDetailId;
	}
	
	
	

}

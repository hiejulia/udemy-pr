package com.project.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="No products found under the teacher")
public class NoProductsFoundUnderTeacherException extends RuntimeException{
	
	private static final long serialVersionUID = 3935230281455340039L;
}

package com.healthfirst.memberfunction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(final String message) {
		super(message);
	}
}

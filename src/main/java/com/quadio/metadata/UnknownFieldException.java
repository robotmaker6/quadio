package com.quadio.metadata;

public class UnknownFieldException extends Exception {
	public UnknownFieldException(String fieldName) {
		super("Unknown metadata field: " + fieldName);  
	}
}

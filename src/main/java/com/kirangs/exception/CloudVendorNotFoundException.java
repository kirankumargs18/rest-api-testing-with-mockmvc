/**
 * @author kiran
 * */
package com.kirangs.exception;

public class CloudVendorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public CloudVendorNotFoundException() {
		super();
	}

	public CloudVendorNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

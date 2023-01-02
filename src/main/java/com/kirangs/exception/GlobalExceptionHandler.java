/**
 * @author kiran
 * */
package com.kirangs.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CloudVendorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCloudVendorNotFoundException(CloudVendorNotFoundException exception,
			WebRequest webRequest) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(new Date());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setPath(webRequest.getDescription(false));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception,
			WebRequest webRequest) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(new Date());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setPath(webRequest.getDescription(false));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	

}

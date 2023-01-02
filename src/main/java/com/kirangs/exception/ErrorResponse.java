/**
 * @author kiran
 * */
package com.kirangs.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private Date timestamp;

	private HttpStatus status;

	private String message;

	private String path;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}

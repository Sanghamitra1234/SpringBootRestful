package com.sleepy.RestServices.exceptions;

import java.util.Date;

public class customErrorDetails  {
	
	
	private Date d;
	private String message;
	private String errorDetails;
	
	private customErrorDetails(Date d, String message, String errorDetails) {
		super();
		this.d = d;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	
	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	
}

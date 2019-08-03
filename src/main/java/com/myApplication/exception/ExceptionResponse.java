package com.myApplication.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String status;
	private String errorMessage;
	private String path;
	
	public ExceptionResponse(Date timeStamp, String status, String errorMessage, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.errorMessage = errorMessage;
		this.path = path;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	

}

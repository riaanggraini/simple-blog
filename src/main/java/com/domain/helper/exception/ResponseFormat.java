package com.domain.helper.exception;
import java.util.Date;

import org.hibernate.annotations.Any;

public class ResponseFormat {
	private Date timestamp;
	private String message;
	private String details;
  private Object data;
	
	public ResponseFormat(Date timestamp, String message, String details, Object data) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
    this.data = data;
	}
	
	public Object getData() {
    return data;
  }
  public void setData(Any data) {
    this.data = data;
  }
  public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
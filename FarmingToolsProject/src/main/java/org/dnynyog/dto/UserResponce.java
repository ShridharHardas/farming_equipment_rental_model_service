package org.dnynyog.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UserResponce {
	private  String code;
	private String status;
	private String message;
	private LocalDateTime timestamp;
	
	public static UserResponce getInstance()
	{
		return new UserResponce();
	}

	public String getCode() {
		return code;
	}

	public UserResponce setCode(String code) {
		this.code = code;
		return this;
	}

	public UserResponce setStatus(String status) {
		this.status = status;
		return this;
	}

	public UserResponce setMessage(String message) {
		this.message = message;
		return this;
	}

	public UserResponce setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	

	
	

}

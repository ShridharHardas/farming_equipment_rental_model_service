package org.dnynyog.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class LoginResponce {

	private  String code;
	private String status;
	private String message;
	private LocalDateTime timestamp;
	
	public static LoginResponce getInstance()
	{
		return new LoginResponce();
	}

	public String getCode() {
		return code;
	}

	public LoginResponce setCode(String code) {
		this.code = code;
		return this;
	}

	public LoginResponce setStatus(String status) {
		this.status = status;
		return this;
	}

	public LoginResponce setMessage(String message) {
		this.message = message;
		return this;
	}

	public LoginResponce setTimestamp(LocalDateTime timestamp) {
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

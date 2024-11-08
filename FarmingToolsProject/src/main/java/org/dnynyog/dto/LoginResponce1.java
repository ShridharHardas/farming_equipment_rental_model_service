package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponce1 {

	private String status;
	private String responce;
	private LoginRequest1 request;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponce() {
		return responce;
	}
	public void setResponce(String responce) {
		this.responce = responce;
	}
	public LoginRequest1 getRequest() {
		return request;
	}
	public void setRequest(LoginRequest1 request) {
		this.request = request;
	}

}

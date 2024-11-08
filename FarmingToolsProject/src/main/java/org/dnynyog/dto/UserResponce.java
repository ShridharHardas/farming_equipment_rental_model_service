package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponce {
	private Integer id;
	private String status;
	private String responce;
	private UserRequest request;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public UserRequest getRequest() {
		return request;
	}
	public void setRequest(UserRequest request) {
		this.request = request;
	}
}

package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
	private Integer id;
	@NotNull(message = "User first name is mandetory ")
	@NotBlank(message = "User First name should not be blank")
	private String firstName;
	@NotNull(message = "User last name is mandetory ")
	@NotBlank(message = "User last name should not be blank")
	private String lastName;
	@NotNull(message = "User email name is mandetory ")
	@NotBlank(message = "User email name should not be blank")
	@Email(message = "Enter the valid email format")
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{4,8}(.)[a-z]{3,5}", message = "Please!,Enter the valid email format")
	private String email;
	@Pattern(regexp = "[a-zA-Z0-9@$]{8}",message = "Please!,Enter the password At given format-@Test123")
	private String password;
//	@NotBlank(message = "pincode is mandatory")
//	@NotNull(message = "pincode should not be blank")
	//@Pattern(regexp ="[0-9]{6}", message = "Please,Enter the valid Pincode")
	private int pincode;
	private Long mobileNo;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
}

package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Component
public class UserRequest {
	@NotBlank(message = "First Name Cannot be blank")
	private String firstName;
	@NotBlank(message = "Last Name Cannot be blank")
	private String lastName;
	@NotBlank(message = "Email Cannot be blank")
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{4,8}(.)[a-z]{3,5}", message = "Please!,Enter the valid email format")
	private String email;
	@Pattern(regexp = "[a-zA-Z0-9@$]{8}",message = "Please!,Enter the password At given format-@Test123")
	@NotBlank(message = "Password Cannot be blank")
	private String password;
	//@NotBlank(message = "Pincode Cannot be blank")
	//@Pattern(regexp = "[0-9]{4-6}",message = "Please,Enter the valid pincode")
	private int pincode;
	//@Pattern(regexp = "[0-9]{10-12}",message = "Please,Enter the valid mobile number")
	//@NotBlank(message = "Mobile Number Cannot be blank")
	private long mobileno;
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	
	


	
}

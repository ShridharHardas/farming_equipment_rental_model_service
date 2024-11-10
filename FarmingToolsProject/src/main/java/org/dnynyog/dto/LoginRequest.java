package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Component
public class LoginRequest {

	@NotBlank(message = "Email Cannot be blank")
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{4,8}(.)[a-z]{3,5}", message = "Please!,Enter the valid email format")
	private String email;
	@Pattern(regexp = "[a-zA-Z0-9@$]{8}",message = "Please!,Enter the password At given format-@Test123")
	@NotBlank(message = "Password Cannot be blank")
	private String password;
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
	
	
}

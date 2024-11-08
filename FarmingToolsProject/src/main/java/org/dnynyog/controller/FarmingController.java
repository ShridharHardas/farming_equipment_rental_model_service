package org.dnynyog.controller;

import org.dnynyog.dto.LoginRequest1;
import org.dnynyog.dto.LoginResponce1;
import org.dnynyog.dto.UserRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/user")
public class FarmingController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("/addUser")
	public UserResponce addUser(@Valid @RequestBody UserRequest request) throws Exception
	{
		return service.addUser(request);
	}
	
	@GetMapping("/validate")
	public LoginResponce1 getValidate(LoginRequest1 loginRequest)
	{
		return service.getValidate(loginRequest);
	}
	
}

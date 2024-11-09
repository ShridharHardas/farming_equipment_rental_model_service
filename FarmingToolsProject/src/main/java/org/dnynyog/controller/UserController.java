package org.dnynyog.controller;

import org.dnynyog.dto.UserRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.service.UserRegistrationImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/gogreen/v1")
public class UserController {
	
	@Autowired
	UserRegistrationImple service;

	@PostMapping(path = "/registration",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	 public UserResponce addUser(@Valid @RequestBody UserRequest request) throws Exception
	 {
		return service.addUser(request);
	 }
		
	
}

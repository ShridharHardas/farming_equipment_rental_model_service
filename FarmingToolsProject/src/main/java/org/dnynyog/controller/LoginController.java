package org.dnynyog.controller;

import org.dnynyog.dto.LoginRequest;
import org.dnynyog.dto.LoginResponce;
import org.dnynyog.service.LoginImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/gogreen/v1")
public class LoginController {

	@Autowired
	LoginImple service;
	
	@PostMapping(path = "/validate",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public LoginResponce validate(@Valid @RequestBody LoginRequest request) throws Exception
	{
		return service.validate(request);
	}
}

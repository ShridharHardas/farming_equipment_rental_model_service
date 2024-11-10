package org.dnynyog.controller;

import java.io.IOException;

import org.dnynyog.dto.OtpRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.service.OtpNotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/gogreen/v1")
public class OtpController {
	
	@Autowired
	OtpNotificationImpl service;
	
	@PostMapping(path = "/otp",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public UserResponce otpValidate(@RequestBody OtpRequest request) throws IOException
	{
		return service.otpValidate(request);
	}

}

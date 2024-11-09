package org.dnynyog.service;

import java.time.LocalDateTime;


import org.dnynyog.dto.UserRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.entity.User;
import org.dnynyog.enums.ResponceCode;
import org.dnynyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationImple {

	@Autowired
	UserRepo repo;
	@Autowired
	AuthService encrypt;
	
	public UserResponce addUser(UserRequest request) throws Exception {
		UserResponce responce=UserResponce.getInstance();
		
		if(request.getFirstName()==null || request.getEmail()==null ||
			request.getLastName()==null || request.getPassword()==null ){
			
			return responce.setCode(ResponceCode.INCOMPLETE_DATA.getCode())
			       .setStatus(ResponceCode.INCOMPLETE_DATA.getStatus())
			       .setMessage(ResponceCode.INCOMPLETE_DATA.getMessage())
				   .setTimestamp(LocalDateTime.now());
		}
		
		User user=User.getInstance()
				.setFirstName(request.getFirstName())
				.setLastName(request.getLastName())
				.setEmail(request.getEmail())
				.setPassword(encrypt.encrypt(request.getPassword()))
				.setPincode(request.getPincode())
				.setMobileno(request.getMobileno());
				
		try
		{
			User userTable=repo.save(user);
			return responce.setCode(ResponceCode.REGISTER_SUCCESS.getCode())
					.setStatus(ResponceCode.REGISTER_SUCCESS.getStatus())
					.setMessage(ResponceCode.REGISTER_SUCCESS.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return responce.setCode(ResponceCode.CATCH_BLOCK_ERROR.getCode())
					.setStatus(ResponceCode.CATCH_BLOCK_ERROR.getStatus())
					.setMessage(ResponceCode.CATCH_BLOCK_ERROR.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
				
		
	}

	
}

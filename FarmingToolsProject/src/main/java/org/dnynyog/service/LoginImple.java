package org.dnynyog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.dnynyog.dto.LoginRequest;
import org.dnynyog.dto.LoginResponce;
import org.dnynyog.entity.User;
import org.dnynyog.enums.ResponceCode;
import org.dnynyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImple {

	@Autowired 
	AuthService decrypt;
	@Autowired
	UserRepo repo;
	public LoginResponce validate(LoginRequest request) throws Exception
	{
		LoginResponce responce=LoginResponce.getInstance();
		User user=User.getInstance();
		//Optional <User> users= Optional.ofNullable(repo.findByEmailAndPassword(request.getEmail(), decrypt.encrypt(request.getPassword()))) ;
		List<User> liuser=repo.findByEmailAndPassword(request.getEmail(), decrypt.encrypt(request.getPassword()));
		if(liuser.size()==1)
		{
			
			return responce.setCode(ResponceCode.LOGIN_SUCCESS.getCode())
					.setStatus(ResponceCode.LOGIN_SUCCESS.getStatus())
					.setMessage(ResponceCode.LOGIN_SUCCESS.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
		else
		{
			
			return responce.setCode(ResponceCode.LOGIN_FAILED.getCode())
					.setStatus(ResponceCode.LOGIN_FAILED.getStatus())
					.setMessage(ResponceCode.LOGIN_FAILED.getMessage())
					.setTimestamp(LocalDateTime.now());
		}
		
	}
}

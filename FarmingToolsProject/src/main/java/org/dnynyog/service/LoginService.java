package org.dnynyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponce;
import org.dnynyog.dto.LoginRequest1;
import org.dnynyog.dto.LoginResponce1;
import org.dnynyog.dto.UserRequest;
import org.dnynyog.dto.UserResponce;
import org.dnynyog.model.User;
import org.dnynyog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class LoginService {

	@Autowired
	UserRepo repo;
	@Autowired
	AuthService encrypt;
	public UserResponce addUser(UserRequest request) throws Exception
	{
		User usertable=new User();
		usertable.setFirstName(request.getFirstName());
		usertable.setLastName(request.getLastName());
		usertable.setEmail(request.getEmail());
		usertable.setPassword(encrypt.encrypt(request.getPassword()));
		usertable.setPincode(request.getPincode());
		usertable.setMobileNo(request.getMobileNo());
		UserResponce responce=new UserResponce();
		User user=repo.save(usertable);
		if(user.getEmail().equals(request.getEmail()) && user.getMobileNo().equals(request.getMobileNo()))
		{
			responce.setId(user.getId());
			responce.setStatus("Active");
			responce.setResponce("Addition Successfully..!");
			return responce;
		}
		else
		{
			
			responce.setStatus("Inctive");
			responce.setResponce("Addition Failed..!");
			return responce;
		}
	}
	
	public LoginResponce1 getValidate(LoginRequest1 loginRequest)
	{
		LoginResponce1 responce=new LoginResponce1();
		Optional<User> user=Optional.ofNullable(repo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()));
		if(user.isPresent())
		{
			responce.setStatus("active");
			responce.setResponce("Login Successfully..!");
			responce.setRequest(loginRequest);
			return responce;
		}
		else
		{
			responce.setStatus("inactive");
			responce.setResponce("Login Failed..!");
			return responce;
			//User userTable=user.get(0);
			

		}
	}
}

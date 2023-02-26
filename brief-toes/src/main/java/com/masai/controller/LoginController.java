package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDto;
import com.masai.service.LoginService;
import com.masai.service.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomerHandler(@RequestBody LoginDto dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	} 
	
	@DeleteMapping("/logout")
	public String logoutCustomerHandler(@RequestParam("key") String key)throws LoginException {
		return customerLogin.logOutFromAccount(key);
	}
	
}

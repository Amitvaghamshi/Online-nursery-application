package com.masai.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDto;
import com.masai.model.UserSession;

public interface LoginService {

	public String logIntoAccount(LoginDto dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
}

package com.masai.service;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.Customer;
import com.masai.model.LoginDto;
import com.masai.model.UserSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	
	private String RandGeneratedStr(int l){

		// a list of characters to choose from in form of a string
		 String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

		 // creating a StringBuffer size of AlphaNumericStr
		 StringBuilder s = new StringBuilder(l);
		 
		 
		 int i;

		 for ( i=0; i<l; i++) {

		   //generating a random number using math.random()
		   int ch = (int)(AlphaNumericStr.length() * Math.random());

		   //adding Random character one by one at the end of s
		   s.append(AlphaNumericStr.charAt(ch));

		  }
		    return s.toString();
	}
	
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	
	
	
	@Override
	public String logIntoAccount(LoginDto dto) throws LoginException {
		
		
        Customer existingCustomer= customerRepository.findByCustomerEmail(dto.getEmail());
		if(existingCustomer == null) {
			throw new LoginException("Please Enter a valid Email Id");
		}
		
		
        Optional<UserSession> validCustomerSessionOpt =  sessionRepository.findById(existingCustomer.getCustomerId());
		if(validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this Email");
		}
		
		
		
         if(existingCustomer.getPassword().equals(dto.getPassword())) {
	    
        	 
        	String key=RandGeneratedStr(10);   // generating random string
			
			UserSession currentUserSession = new UserSession(existingCustomer.getCustomerId(),key);
			sessionRepository.save(currentUserSession);
			return currentUserSession.toString();
		 }
		 else
			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
        UserSession validCustomerSession = sessionRepository.findByuuid(key);
		
        System.out.println(validCustomerSession);
        
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this Email");
			
		}
		sessionRepository.delete(validCustomerSession);
		
		return "Logged Out !";
	}
	
	
	
	
	
	

	
}

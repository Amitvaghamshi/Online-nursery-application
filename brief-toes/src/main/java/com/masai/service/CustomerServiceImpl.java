package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PlanterException;
import com.masai.model.Customer;

import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private  CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws PlanterException {
		
		Customer newCustomer = customerRepo.save(customer);
			
		 if(newCustomer==null) throw new PlanterException("Can't add this newCustomer");
			
		 else return newCustomer;
		

	}


}

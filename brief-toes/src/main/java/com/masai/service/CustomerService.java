package com.masai.service;

import java.util.List;

import com.masai.exceptions.PlanterException;
import com.masai.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws PlanterException;


}

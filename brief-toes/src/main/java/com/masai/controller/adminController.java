package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PlanterException;
import com.masai.model.Customer;
import com.masai.model.Planter;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.PlanterService;
import com.masai.service.adminCustomer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	private PlanterService planterService;
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private adminCustomer adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Customer> saveNewCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		
		 Customer savedCustomer = adminService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/delete/{customerId}")
	public ResponseEntity<Customer> deleteCutomer(@PathVariable Integer customerId) throws CustomerException{

		Customer deletedCustomer = null;
		
		deletedCustomer = adminService.deleteCustomer(customerId);
		

		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)throws CustomerException{

		Customer updatedCustomer = null;
		
		updatedCustomer = adminService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
	}
	

}

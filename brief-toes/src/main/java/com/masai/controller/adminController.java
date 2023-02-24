package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
	
	@PostMapping("/admin/{adminID}")
	public ResponseEntity<Customer> saveNewCustomer(@Valid @RequestBody Customer customer,@PathVariable Integer adminID) throws CustomerException{
		
		Customer savedCustomer = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
			savedCustomer = adminService.addCustomer(savedCustomer);
		
		else
		throw new CustomerException("You are not an admin");
		
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/{adminID}/delete/{customerId}")
	public ResponseEntity<Customer> deleteCutomer(@PathVariable Integer customerId, @PathVariable Integer adminID) throws CustomerException{

		Customer deletedCustomer = null;
		
		if(adminID==100||adminID==200||adminID==300||adminID==400)
		deletedCustomer = adminService.deleteCustomer(customerId);
		
		else
		throw new CustomerException("You are not an admin");

		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/{adminID}/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Integer adminID)throws CustomerException{

		Customer updatedCustomer = null;
		
		if(adminID==100||adminID==200||adminID==300||adminID==400)
		updatedCustomer = adminService.updateCustomer(customer);
		
		else
		throw new CustomerException("You are not an admin");
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
	}
	

}

package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PlantException;
import com.masai.exceptions.PlanterException;
import com.masai.exceptions.SeedException;
import com.masai.model.Customer;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.CustomerRepository;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
import com.masai.repository.SeedRepository;

@Service
public class adminCustomerImpl implements adminCustomer {
	
	@Autowired
	private PlanterRepository planterRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SeedRepository seedRepository;
	
	@Autowired
	private PlantRepository planRrepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		 Customer newCustomer = customerRepository.save(customer);
			
		 if(newCustomer==null) throw new CustomerException("Can't add new Customer");
			
		 else return newCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> existedCustomer = customerRepository.findById(customer.getCustomerId());		
		
		if(existedCustomer.isPresent()) {
			return customerRepository.save(customer);
		}
		else
			throw  new CustomerException("Customer Not Found");
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> existedCustomer = customerRepository.findById(customerId);		
		
		if(existedCustomer.isPresent()) {
			Customer deleteCustomer=existedCustomer.get();
			customerRepository.delete(deleteCustomer);
			return deleteCustomer;
		}
		else
			throw  new CustomerException("No such Customer present, You can't delete");
	}

	@Override
	public List<Plant> getAllPlants() throws PlantException {
		List<Plant> plants=planRrepository.findAll();
		
		if(plants.isEmpty()) {
			throw new PlantException("plant Not found");
		}
		return plants;
	}

	@Override
	public List<Seed> getAllSeeds() throws SeedException {
        List<Seed> plants=seedRepository.findAll();
		if(plants.isEmpty()) {
			throw new SeedException("Seeds Not found");
		}
		return plants;
	}

	@Override
	public List<Planter> getAllPlanters() throws PlanterException {
		  List<Planter> planter=planterRepository.findAll();
			if(planter.isEmpty()) {
				throw new PlanterException("planter Not found");
			}
			return planter;
	}
	




	

}

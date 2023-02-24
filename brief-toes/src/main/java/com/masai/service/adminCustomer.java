package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.PlantException;
import com.masai.exceptions.PlanterException;
import com.masai.exceptions.SeedException;
import com.masai.model.Customer;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;

public interface adminCustomer {
	
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public List<Plant> getAllPlants() throws PlantException;
	
	public List<Seed> getAllSeeds() throws SeedException;
	
	public List<Planter> getAllPlanters() throws PlanterException;
	
	

}

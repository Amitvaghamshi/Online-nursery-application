package com.masai.service;

import java.util.List;

import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;

public interface CustomerService {
	
	public List<Plant> getAllPlants();
	public List<Seed> getAllSeeds();
	public List<Planter> getAllPlanters();
}

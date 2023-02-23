package com.masai.service;

import java.util.List;

import com.masai.exceptions.PlantException;
import com.masai.exceptions.PlanterException;
import com.masai.exceptions.SeedException;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;

public interface CustomerService {
	

	public List<Plant> getAllPlants() throws PlantException;
	public List<Seed> getAllSeeds() throws SeedException;
	public List<Planter> getAllPlanters() throws PlanterException;
	public List<Plant> getSortedPlantByHeightOrWidth(Integer pagesize, Integer pageNo, String sortby) throws PlantException;
	public List<Planter> getSortedPlanterByHeightOrCapacity(Integer pagesize, Integer pageNo, String sortby) throws PlanterException;
	public List<Seed> getSortedSeedByBloomOrWater(Integer pagesize, Integer pageNo, String sortby) throws SeedException;
	


}

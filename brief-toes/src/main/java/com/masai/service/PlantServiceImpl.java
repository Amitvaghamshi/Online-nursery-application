package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PlantException;
import com.masai.model.Plant;
import com.masai.repository.PlantRepository;

@Service
public class PlantServiceImpl implements PlantService {
	
	@Autowired
	private PlantRepository plantRepo;

	
	
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		
		Plant savedPlant = plantRepo.save(plant);
		
		 if(savedPlant==null) throw new PlantException("Can't add this plant");
			
		 else return savedPlant;
		
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		
		Integer plantId = plant.getPlantId();
		
		Optional<Plant> found = plantRepo.findById(plantId);	
		
		if(found.isPresent()) {
			return plantRepo.save(plant);
		}
		else
			throw  new PlantException("Cannot Update, No such Plant present ");			
	}

	@Override
	public Plant deletePlant(Integer plantId) throws PlantException {
		
		
		
		Optional<Plant> found = plantRepo.findById(plantId);		
		
		if(found.isPresent()) {
			Plant plant = found.get();
			plantRepo.delete(plant);
			return plant;
		}
		else
			throw  new PlantException("Cannot Delete No such Plant present ");
		
	}

	@Override
	public Plant viewPlant(Integer plantId) throws PlantException {
		
		Optional<Plant> found = plantRepo.findById(plantId);		
		
		return found.orElseThrow( ()-> new PlantException(
		"Unable to find Plant with id "+plantId));
		
	}

	@Override
	public List<Plant> viewPlant(String commonName) throws PlantException {
		List<Plant> plantListByCommonName;
		
		plantListByCommonName = plantRepo.findByCommonName(commonName);
		
		if(plantListByCommonName.size()!=0)
		return plantListByCommonName;
		else
		throw  new PlantException("Cannot find any plant by this common name ");
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		
		List<Plant> allPlants;
		
		allPlants = plantRepo.findAll();
		
		if(allPlants.size()!=0)
		return allPlants;
		else
		throw  new PlantException("We don't have any plants in the database ");
		
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException {
		
		List<Plant> allPlantsByOneType;
		
		allPlantsByOneType = plantRepo.findAll();
		
		if(allPlantsByOneType.size()!=0)
		return allPlantsByOneType;
		else
		throw  new PlantException("We don't have this type of "+typeOfPlant+" in the database");
		
	}

}

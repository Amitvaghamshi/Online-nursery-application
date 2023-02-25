package com.masai.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.PlantException;
import com.masai.model.Plant;
import com.masai.service.PlantService;



@RestController
@RequestMapping("/plant")
public class PlantController {

	
	
	
	
	
	
	@Autowired
	private PlantService plantService;
	
	
	
	@PostMapping("/{adminID}/add")
	public ResponseEntity<Plant> saveNewPlant(@Valid @RequestBody Plant plant, @PathVariable("adminID") Integer adminID)throws AdminException,PlantException{
		Plant savedPlant = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444) 
		savedPlant = plantService.addPlant(plant);
		
		else
		throw new AdminException("You are not an admin");
		
		
		return new ResponseEntity<Plant>(savedPlant, HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/{adminID}/delete/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId,
			@PathVariable Integer adminID)
			throws AdminException,PlantException{

		Plant deletedPlant=null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
		deletedPlant = plantService.deletePlant(plantId);
			
		else
		throw new AdminException("You are not an admin");

		return new ResponseEntity<Plant>(deletedPlant, HttpStatus.OK);
	}
	
	@PutMapping("/{adminID}/update")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant
			,@PathVariable Integer adminID)
			throws AdminException,PlantException{
		Plant updatedPlant= null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
		updatedPlant = plantService.updatePlant(plant);
			
		else
		throw new AdminException("You are not an admin");		

		return new ResponseEntity<Plant>(updatedPlant, HttpStatus.CREATED);
	}
	
	@GetMapping("/byID/{plantId}")
	public ResponseEntity<Plant> getSpecificPlant(@PathVariable Integer plantId)
			throws PlantException{

		Plant specificPlant = plantService.viewPlant(plantId);

		return new ResponseEntity<Plant>(specificPlant, HttpStatus.OK);
	}
	
	@GetMapping("/{commonName}")
	public ResponseEntity<List<Plant>> viewPlantByCommonName(@PathVariable String commonName)
			throws PlantException{

		List<Plant> plantsByCommonName = plantService.viewPlant(commonName);

		return new ResponseEntity<List<Plant>>(plantsByCommonName, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Plant>> viewAllPlants()
			throws PlantException{

		List<Plant> allPlants = plantService.viewAllPlants();
		

		return new ResponseEntity<List<Plant>>(allPlants, HttpStatus.OK);
	}
	
	@GetMapping("/all/{plantType}")
	public ResponseEntity<List<Plant>> viewAllPlantsByTypeOfPlant(@PathVariable String plantType)
			throws PlantException{
		List<Plant> allPlants = plantService.viewAllPlants(plantType);		

		return new ResponseEntity<List<Plant>>(allPlants, HttpStatus.OK);
	}
	
	
}
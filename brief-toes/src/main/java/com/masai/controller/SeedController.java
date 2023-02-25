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
import com.masai.exceptions.SeedException;
import com.masai.model.Seed;
import com.masai.service.PlantService;
import com.masai.service.PlanterService;
import com.masai.service.SeedService;



@RestController
@RequestMapping("/seed")
public class SeedController {
	
	
	@Autowired 
	private SeedService seedService;
	@Autowired
	private PlantService plantService;
	@Autowired
	private PlanterService planterService;
		
	
	@PostMapping("/{adminID}/add")
	public ResponseEntity<Seed> saveNewSeed(@Valid @RequestBody Seed seed
			,@PathVariable Integer adminID)
			throws AdminException,SeedException{
		
		Seed savedSeed = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444) 
		savedSeed = seedService.addSeed(seed);
		
		else
		throw new AdminException("You are not an admin");
				
		return new ResponseEntity<Seed>(savedSeed, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{adminID}/delete/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId,
			@PathVariable Integer adminID)
			throws AdminException,SeedException{
		
		Seed deletedSeed = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444) 
		deletedSeed = seedService.deleteSeed(seedId);
		
		else
		throw new AdminException("You are not an admin");	

		return new ResponseEntity<Seed>(deletedSeed, HttpStatus.OK);
	}
	@PutMapping("/{adminID}/update")
	public ResponseEntity<Seed> updateSeed(@Valid @RequestBody Seed seed
			,@PathVariable Integer adminID)
			throws AdminException,SeedException{
		
		Seed updatedSeed = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444) 
		updatedSeed = seedService.updateSeed(seed);
		
		else
		throw new AdminException("You are not an admin");	

		return new ResponseEntity<Seed>(updatedSeed, HttpStatus.CREATED);
	}
	
	@GetMapping("/seed/byID/{seedid}")
	public ResponseEntity<Seed> getSpecificSeed(@PathVariable Integer seedid)
			throws SeedException{

		Seed specificSeed = seedService.viewSeed(seedid);

		return new ResponseEntity<Seed>(specificSeed, HttpStatus.OK);
	}
	
	@GetMapping("/seed/{commonName}")
	public ResponseEntity<List<Seed>> viewSeedByCommonName(@PathVariable String commonName)
			throws SeedException{

		List<Seed> seedsByCommonName = seedService.viewSeed(commonName);

		return new ResponseEntity<List<Seed>>(seedsByCommonName, HttpStatus.OK);
	}
	
	@GetMapping("/seed/all")
	public ResponseEntity<List<Seed>> viewAllSeeds()
			throws SeedException{

		List<Seed> allSeeds = seedService.viewAllSeeds();
		

		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
	}
	
	@GetMapping("/seed/all/{seedType}")
	public ResponseEntity<List<Seed>> viewAllSeedsByTypeOfSeed(@PathVariable String seedType)
			throws SeedException{
		List<Seed> allSeeds = seedService.viewAllSeeds(seedType);		

		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
	}
	
	
}

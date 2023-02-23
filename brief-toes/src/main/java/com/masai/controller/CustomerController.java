package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.PlantException;
import com.masai.exceptions.PlanterException;
import com.masai.exceptions.SeedException;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl costomerController;

	   @GetMapping(value = "/plants",produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<Plant>> getAllplantsHandler() throws PlantException{
		   List<Plant> plants=costomerController.getAllPlants();
		   return new ResponseEntity<>(plants,HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/plants")
	   public ResponseEntity<List<Plant>> getSortedPlantByHeightOrWidthHandler(@RequestParam("pagesize") Integer pagesize,@RequestParam("pageno") Integer pageNo,@RequestParam("sortby") String sortby) throws PlantException{
		   List<Plant> plants=costomerController.getSortedPlantByHeightOrWidth(pagesize, pageNo, sortby);
		   return new ResponseEntity<>(plants,HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/planters",produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<Planter>> getAllPlantersHandler() throws PlanterException {
		   List<Planter> planters=costomerController.getAllPlanters();
		   return new ResponseEntity<>(planters,HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/planters")
	   public ResponseEntity<List<Planter>> getSortedPlanterByHeightOrCapacityHandler(@RequestParam("pagesize") Integer pagesize,@RequestParam("pageno") Integer pageNo,@RequestParam("sortby") String sortby)throws PlanterException{
		   List<Planter> plants=costomerController.getSortedPlanterByHeightOrCapacity(pagesize, pageNo, sortby);
		   return new ResponseEntity<>(plants,HttpStatus.OK);
	   }
	   
	   
	   @GetMapping(value = "/seeds",produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<Seed>> getAllSeedsHandler() throws SeedException {
		   List<Seed> seeds=costomerController.getAllSeeds();
		   return new ResponseEntity<>(seeds,HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/planters")
	   public ResponseEntity<List<Seed>> getSortedSeedByBloomOrWaterHandler(@RequestParam("pagesize") Integer pagesize,@RequestParam("pageno") Integer pageNo,@RequestParam("sortby") String sortby) throws SeedException{
		   List<Seed> plants=costomerController.getSortedSeedByBloomOrWater(pagesize, pageNo, sortby);
		   return new ResponseEntity<>(plants,HttpStatus.OK);
	   }
	   
}

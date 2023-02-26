package com.masai.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.PlanterException;
import com.masai.model.Planter;

import com.masai.service.PlanterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/planter")
public class PlanterController {

	
		@Autowired
		private PlanterService planterService;
		
		
		@PostMapping("/add")
		public ResponseEntity<Planter> saveNewPlanter(@Valid @RequestBody Planter planter) throws PlanterException{
			
			Planter savedPlanter = planterService.addPlanter(planter);	
			return new ResponseEntity<Planter>(savedPlanter, HttpStatus.CREATED);
		}
		
		
		@DeleteMapping("/delete/{planterId}")
		public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) throws PlanterException{

			Planter deletedPlanter =planterService.deletePlanter(planterId);
			

			return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
		}
		
		@PutMapping("/update")
		public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter)throws PlanterException{

			Planter updatedPlanter = planterService.updatePlanter(planter);
			
			
			return new ResponseEntity<Planter>(updatedPlanter, HttpStatus.CREATED);
		}
		
		@GetMapping("/byID/{planterId}")
		public ResponseEntity<Planter> getSpecificPlanterById(@PathVariable Integer planterId)throws PlanterException{

			Planter specificPlanter = planterService.viewPlanter(planterId);

			return new ResponseEntity<Planter>(specificPlanter, HttpStatus.OK);
		}
		
		@GetMapping("/{planterShape}")
		public ResponseEntity<List<Planter>> viewPlanterByShape(@PathVariable String planterShape) throws PlanterException{

			List<Planter> plantersByShape = planterService.viewPlanter(planterShape);

			return new ResponseEntity<List<Planter>>(plantersByShape, HttpStatus.OK);
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Planter>> viewAllPlanters() throws PlanterException{

			List<Planter> allPlanters = planterService.viewAllPlanters();
			

			return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
		}
		
		@GetMapping("/all/range")
		public ResponseEntity<List<Planter>> viewAllPlantersByTypeOfPlanter (@RequestParam Double minCost,@RequestParam Double maxCost) throws PlanterException{
			List<Planter> allPlanters = planterService.
							viewAllPlanters(minCost, maxCost);	

			return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
		}

}

package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PlanterException;
import com.masai.model.Planter;
import com.masai.repository.PlanterRepository;

@Service
public class PlanterServiceImpl implements PlanterService{
	@Autowired
	private PlanterRepository planterRepo;
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		
		 Planter newPlanter = planterRepo.save(planter);
			
		 if(newPlanter==null) throw new PlanterException("Can't add this newPlanter");
			
		 else return newPlanter;
		
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
	
		Optional<Planter> existedPlanter = planterRepo.findById(planter.getPlanterId());		
		
		if(existedPlanter.isPresent()) {
			return planterRepo.save(planter);
		}
		else
			throw  new PlanterException("Planter Not Found");
		
	}

	@Override
	public Planter deletePlanter(Integer planterId) throws PlanterException {
		
		Optional<Planter> existedPlanter = planterRepo.findById(planterId);		
		
		if(existedPlanter.isPresent()) {
			Planter deletePlanter=existedPlanter.get();
			planterRepo.delete(deletePlanter);
			return deletePlanter;
		}
		else
			throw  new PlanterException("No such Planter present, You cant delete");
	}
	@Override
	public Planter viewPlanter(Integer planterId) throws PlanterException {
		
		Optional<Planter> existed = planterRepo.findById( planterId);		
		
		return existed.orElseThrow( ()-> new PlanterException(
		"Can't view Planter with id "+planterId));
		
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) throws PlanterException {
	
	
		List<Planter> allPlanters;
		
		allPlanters = planterRepo.findByPlanterShape(planterShape);
		
		if(allPlanters.size()!=0)
		return allPlanters;
		else
		throw  new PlanterException("We don't have any "+planterShape +"shaped planters.");
	
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
		List<Planter> allPlanters;
		
		allPlanters = planterRepo.findAll();
		
		if(allPlanters.size()!=0)
		return allPlanters;
		else
		throw  new PlanterException("There is no plater...");
		
	}

	@Override
	public List<Planter> viewAllPlanters(double min, double max) throws PlanterException {
		
		List<Planter> PlantersBetweenRange;
		
		PlantersBetweenRange = planterRepo.findByPlanterCostBetween(min, max);
		
		if(PlantersBetweenRange.size()!=0)
		return PlantersBetweenRange;
		else
		throw  new PlanterException("There is no planter between "+min+" and "+max);
		
	}
	
}

package com.masai.service;

import java.util.List;

import com.masai.exceptions.PlanterException;
import com.masai.model.Planter;

public interface PlanterService {
	
	public Planter addPlanter(Planter planter) throws PlanterException;

	public Planter updatePlanter(Planter planter) throws PlanterException;

	public Planter deletePlanter(Integer planterId) throws PlanterException;

	public Planter viewPlanter(Integer planterId) throws PlanterException;

	public List<Planter> viewPlanter(String planterShape) throws PlanterException;

	public List<Planter> viewAllPlanters() throws PlanterException;

	public List<Planter> viewAllPlanters(double min, double max) throws PlanterException;

}

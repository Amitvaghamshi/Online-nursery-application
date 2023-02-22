package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface PlanterRepository extends JpaRepository<Planter, Integer> {
	
	public List<Planter> findByPlanterCostBetween(double start,double end);

	
}
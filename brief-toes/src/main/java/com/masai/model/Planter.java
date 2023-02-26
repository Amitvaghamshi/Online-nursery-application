package com.masai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer planterId;
	
	@Min(value=2 , message = "Planter height should be more than 2")
	private Double planterHeight;
	
	@Min(value=2 , message = "Planter capacity cannot be less than 2")
	private Double planterCapacity;
	
	@Min(value=5 , message = "Drainage holes should not be less than 5")
	private Integer drainageHoles;
	
	@NotNull
	private String planterColor;
	
	@NotNull
	private String planterShape;
	
	@Min(value=1 , message = "Planter stock should be atleast 1")
	private Integer planterStock;
	
//	@Size(min=30,max=500, message = "Planter cost is between 30 to 500")
	private Integer planterCost;
	
//	@OneToMany
//	Seed seed;
//	@OneToMany
//	Plant plant;
	


}

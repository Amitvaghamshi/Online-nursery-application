package com.masai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	@Min(value = 1, message = "Plant height cannot be zero")
	private Integer plantHeight;
	
	@NotBlank
	private String plantSpread;
	
	@NotBlank
	private String commonName;
	
	@NotBlank
	private String bloomTime;
	
	@NotBlank
	private String medicalOrCulinaryUse;
	
	@NotBlank
	private String difficultyLevel;
	
	@NotBlank
	private String temprature;
	
	@NotBlank
	private String typeOfPlant;
	
	@NotBlank
	private String plantDescription;
	
	
	@Min(value = 3, message = "Plant stock cannnot be negative")
	private Integer plantStock;
	
	@Min(value = 1, message = "Plant height cannot be zero")
	private Integer plantCost;
	
	

}

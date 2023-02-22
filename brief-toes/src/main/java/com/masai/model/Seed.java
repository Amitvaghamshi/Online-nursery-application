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
public class Seed {
	
	// name should have some
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	
	@NotBlank(message="Name can not be blank")
	private String commonName;
	
	@NotBlank
	private String bloomTime;
	
	@NotBlank
	private String watering;
	
	@NotBlank
	private String difficultyLevel;
	
	@NotBlank
	private String temperature;
	
	@NotBlank
	private String typeOfSeeds;
	
	@NotBlank
	private String seedsDescription;
	
	@Min(value = 0, message = "Seed's stock can't be negative")
	private Integer seedsStock;
	
	@Min(value = 1, message = "Seed's cost should not be zero")
	private Double seedsCost;
	
	@Min(value = 1, message = "There cannot be zero seeds in a packet")
	private Integer seedsPerPacket;

}

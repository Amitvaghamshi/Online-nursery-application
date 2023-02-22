package com.masai.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "add")
	  @SequenceGenerator(name = "add",sequenceName = "add_seq",initialValue = 1,allocationSize = 1)
	  private Integer addId;
	  private String houseNo;
	  private String colony;
	  private String city;
	  private String state;
	  @Pattern(regexp = "[0-9]{6}")
	  private String pincode;
	  
	  
}

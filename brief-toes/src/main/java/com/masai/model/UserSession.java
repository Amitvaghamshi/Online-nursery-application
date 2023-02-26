package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class UserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	
	
	private String uuid;
	
	private final LocalDateTime localDateTime=LocalDateTime.now();
}

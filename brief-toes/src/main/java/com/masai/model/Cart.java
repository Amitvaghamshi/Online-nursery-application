package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orders")
	@SequenceGenerator(name = "orders" ,sequenceName = "orders_seq" ,initialValue = 100,allocationSize = 1)
	private Integer cartId;
	@Enumerated(EnumType.STRING)
	private OrderType orderType;
	@NotNull
	@Min(value = 1,message = "order iteam can not be less than 1")
	private Integer quantity;
	@NotNull
	@Min(value = 0,message = "order amount can not be less than 0")
	private Integer cost;
	private String description;
	private final LocalDateTime timeStamp=LocalDateTime.now();
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	private Customer customer_cart;
	
}

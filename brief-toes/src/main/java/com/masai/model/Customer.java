package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Customer {

	   @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "customer_id")
	   @SequenceGenerator(name = "customer_id",sequenceName = "customer_seq",allocationSize = 1,initialValue = 101)
	   private Integer customerId;
	   @NotEmpty
	   @NotNull
	   private String customerName;
	   @NotNull
	   @Pattern(regexp = "^[6-9]{1}[0-9]{9}" , message = "phone number must be of 10 num")
	   private String phone;
	   @NotNull
	   @NotNull(message = "email  can not be null")
	   @Email(message = "Email is not valid")
	   private String customerEmail;
	   @NotEmpty(message = "user name can not be empty")
	   @NotNull(message = "user name can not be null")
	   private String username;
	   @Pattern(regexp ="((?=.*[*!@#$&])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,15})" ,message = "password should contain at least one uppercase and one lowercase and one special character" )
	   @NotNull
	   private String password;
	   
	   @Embedded
	   @ElementCollection
	   @JoinTable(name = "customer_addresses",joinColumns = @JoinColumn(columnDefinition = "customer_id"))
	   private List<Address> addresses=new ArrayList<>();
	   
	   @JsonIgnore
	   @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	   private List<Orders> orders=new ArrayList<Orders>();
	   
	   @JsonIgnore
	   @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer_cart")
	   private List<Cart> cart_iteams=new ArrayList<Cart>();
	   
}

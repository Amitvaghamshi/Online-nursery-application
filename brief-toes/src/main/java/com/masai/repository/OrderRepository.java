package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}

package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;
import com.masai.service.OrderServices;


 
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	   @Autowired
	  private OrderServices orderServices;

	  //create order
	  @PostMapping("/")
	  public ResponseEntity<Orders> createOrderHandler(@RequestBody Orders order){
		  
		 Orders saveOrder = orderServices.addOrder(order);
		 
		 return new ResponseEntity<Orders>(saveOrder,HttpStatus.OK);
		  
	  }
	  
	  //update order
	  @PutMapping("/update")
	  public ResponseEntity<Orders> updateOrderHandler(@RequestBody Orders order) throws OrderException{
		  
		  Orders updatedOrder = orderServices.updateOrder(order);
		  
		  return new ResponseEntity<Orders>(updatedOrder,HttpStatus.OK);
	  }
	  
	 //delete order by id
	 @DeleteExchange("/delete/{orderID}") 
	 public ResponseEntity<Orders> deleteOrderHandler(@PathVariable("orderID") Integer orderId) throws OrderException{
		 
		Orders deletedOrder =  orderServices.deleteOrder(orderId);
		
		return new ResponseEntity<Orders>(deletedOrder,HttpStatus.ACCEPTED);
		 
	 }
	 
	 //view Order by id
	 @GetMapping("/view/{orderID}")
	 public ResponseEntity<Orders> viewOderDetailsById(@PathVariable("orderID") Integer orderId) throws OrderException{
		 
		 Orders existingorder = orderServices.viewOrder(orderId);
		 
		 return new ResponseEntity<Orders>(existingorder,HttpStatus.FOUND);
		 
	 }
	 
	 //view all Order
	 @GetMapping("/view")
	 public ResponseEntity<List<Orders>> getAllOrderDetailsHandler() throws OrderException{
		 
		 List<Orders> orders =  orderServices.viewAllOrder();
		 
		 return new ResponseEntity<List<Orders>>(orders,HttpStatus.OK);
	 }
	
	
	

}

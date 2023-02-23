package com.masai.service;

import java.util.List;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

public interface OrderServices {
	
	
	//create order
	Orders addOrder(Orders order);
	
	//update order
	Orders updateOrder(Orders order)throws OrderException;
	
	//delete order
	Orders deleteOrder(Integer orderId)throws OrderException;
	
	//view Order
	Orders viewOrder(Integer orderId)throws OrderException;
	
	//view all Order
	List<Orders> viewAllOrder()throws OrderException;

}

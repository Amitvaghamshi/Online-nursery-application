package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrderException;
import com.masai.model.Cart;
import com.masai.model.Orders;

public interface OrderService {

	    public Orders createOrder(Cart cart,Integer customerId,String payment) throws CustomerException,OrderException;
	   
		//update order
		Orders updateOrder(Orders order)throws OrderException;
		
		//delete order
		Orders deleteOrder(Integer orderId)throws OrderException;
		
		//view Order
		Orders viewOrder(Integer orderId)throws OrderException;
		
		//view all Order
		List<Orders> viewAllOrder()throws OrderException;

}

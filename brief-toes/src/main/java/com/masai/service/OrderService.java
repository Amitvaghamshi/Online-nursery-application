package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrderException;
import com.masai.model.Cart;
import com.masai.model.Orders;

public interface OrderService {

	   public Orders createOrder(Cart cart,Integer customerId,String payment) throws CustomerException,OrderException;
}

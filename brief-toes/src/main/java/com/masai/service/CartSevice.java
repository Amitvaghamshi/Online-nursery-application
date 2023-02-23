package com.masai.service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Cart;

public interface CartSevice {

 	public Cart addtoCart(Integer customerId, Cart cart) throws CartException, CustomerException;
	public Cart removeFromCart(Integer customerId, Integer orderID)  throws CartException, CustomerException;
}

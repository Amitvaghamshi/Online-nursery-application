package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;


@Service
public class CartServiceImpl implements CartSevice{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addtoCart(Integer customerId,Cart cart) throws CartException ,CustomerException{
		
		Optional<Customer> customeropt=customerRepository.findById(customerId);
		
		if(!customeropt.isPresent()) {
			 throw new CustomerException("Customer Not found with id :"+customerId);
		}
		
		Customer customer=customeropt.get();
		customer.getCart_iteams().add(cart);
		cart.setCustomer(customer);
		
		customerRepository.save(customer);
		
		return cart;
	}
	
	

	@Override
	public Cart removeFromCart(Integer customerId, Integer cartId) throws CartException, CustomerException {
		
Optional<Customer> customeropt=customerRepository.findById(customerId);
		
		if(!customeropt.isPresent()) {
			 throw new CustomerException("Customer Not found with id :"+customerId);
		}
		
		Customer customer=customeropt.get();
		
		Cart cart=null;
		
		for(int i=0;i<customer.getCart_iteams().size();i++) {
			    if(customer.getCart_iteams().get(i).getCartId()==cartId){
			    	cart=customer.getCart_iteams().get(i);
			    	customer.getCart_iteams().remove(i);
			    }
		}
		if(cart==null) {
			throw new CartException("Cart Iteam not Found");
		}
		
		customerRepository.save(customer);

		return cart;
		
	}
	
	
	
	

	

	
}

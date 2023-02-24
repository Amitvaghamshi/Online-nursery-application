package com.masai.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrderException;
import com.masai.mail.SendMail;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired OrderRepository orderrepository;
	

	@Override
	public Orders createOrder(Cart cart, Integer customerId,String payment) throws CustomerException, OrderException {
		
        Optional<Customer> customeropt=customerRepository.findById(customerId);
		
		if(!customeropt.isPresent()) {
			 throw new CustomerException("Customer Not found with id :"+customerId);
		}
		
		Customer customer=customeropt.get();
		
        Integer cartId=cart.getCartId();
        
        Cart actcart=null;
		
		for(int i=0;i<customer.getCart_iteams().size();i++){
			    if(customer.getCart_iteams().get(i).getCartId().equals(cartId)){
			    	actcart=customer.getCart_iteams().get(i);
			    	customer.getCart_iteams().remove(i);
			    }
		}
	
		
		cartRepository.delete(actcart);
		
		Orders order=new Orders();
		
		 order.setCost(cart.getCost());
		// order.setAddress(customer.getAddresses());
		 order.setQuantity(cart.getQuantity());
		 order.setOrderType(cart.getOrderType());
		 order.setTotalCost(cart.getCost()*cart.getQuantity());
		 order.setPaymentType(payment);
		
		
		order.setCustomer(customer);
		customer.getOrders().add(order);
		
		
		customerRepository.save(customer);
		
		
		try {
			
			File f=new File("orderDetails.txt");
			
			PrintWriter printwriter=new PrintWriter(f);
			printwriter.println( customer.getCustomerName() +" Thank you for the Order " );
			printwriter.println("This is your Order Details ");
			printwriter.println("-----------------------------");
			printwriter.println("Order Type : " +order.getOrderType());
			printwriter.println("Cost :" +order.getCost());
			printwriter.println("Total Quantity :" + order.getQuantity());
			printwriter.println("Total Cost :"+order.getTotalCost());
			printwriter.println("Payment Type :" +order.getPaymentType());
			printwriter.println("Address :"+order.getAddress());
		    
			printwriter.flush();
			printwriter.close();
			
			boolean ms= SendMail.sendEmail( customer.getCustomerEmail(),"amitvaghamshi123@gmail.com", "Order Placed SucessFully", "Thank you for shopping at NurseryNow !",f);
			System.out.println(ms);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return   orderrepository.save(order);
		
	}

}

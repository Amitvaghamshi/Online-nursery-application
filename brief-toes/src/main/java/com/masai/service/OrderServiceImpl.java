package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;
import com.masai.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderServices{
	
	@Autowired
	private OrderRepository orderDao;

	//create order
	@Override
	public Orders addOrder(Orders order) {
		
		return orderDao.save(order);
		
	}

	//update order
	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		
		Orders existingOrder = orderDao.findById(order.getOrderId()).get();
		
		if(existingOrder==null) {
			throw new OrderException("Order not found with id :"+order.getOrderId());
		}
		
		
		existingOrder.setCost(order.getCost());
		existingOrder.setCustomer(order.getCustomer());
		existingOrder.setQuantity(order.getQuantity());
		existingOrder.setPaymentType(order.getPaymentType());
		existingOrder.setOrderType(order.getOrderType());
		
		return existingOrder;
	}

	//delete order
	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
	    
		Orders existingOrder = orderDao.findById(orderId).get();
		
		if(existingOrder == null) {
			throw new OrderException("Order not found with orderId :"+orderId);
		}
		
		orderDao.delete(existingOrder);
		return existingOrder;
	}

	//view order by id
	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		
        Orders existingOrder = orderDao.findById(orderId).get();
		
		if(existingOrder == null) {
			throw new OrderException("Order not found with orderId :"+orderId);
		}
		
	
		return existingOrder;
	}

	//view all order
	@Override
	public List<Orders> viewAllOrder() throws OrderException {

        List<Orders> orders = orderDao.findAll();
        
        if(orders.isEmpty()) throw new OrderException("order not found");
        
		return  orders;
	}

	
}

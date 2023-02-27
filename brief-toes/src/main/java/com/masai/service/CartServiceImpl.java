package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Fertilizer;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.FertilizerRepository;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
import com.masai.repository.SeedRepository;


@Service
public class CartServiceImpl implements CartSevice{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private SeedRepository seedRepository;
	
	@Autowired
	private PlantRepository plantRepository; 
	
	@Autowired
	private PlanterRepository planterRepository;
	
	@Autowired
	private FertilizerRepository fertilizerRepo;
	
	
	

	@Override
	public Cart addtoCart(Integer customerId,Cart cart,Integer productId) throws CartException ,CustomerException{
		
		Optional<Customer> customeropt=customerRepository.findById(customerId);
		
		
		if(!customeropt.isPresent()) {
			 throw new CustomerException("Customer Not found with id :"+customerId);
		}
		
		System.out.println();
		
		if(cart.getOrderType().toString().equals("PLANT")){
			Plant plant=plantRepository.findById(productId).get();
			cart.setDescription(" plantHeight :"+plant.getPlantHeight()+" plantSpread :"+plant.getPlantSpread()+" commonName :"+plant.getCommonName()+" bloomTime :"+plant.getBloomTime()+" typeOfPlant :"+plant.getTypeOfPlant()+" plantDescription :"+plant.getPlantDescription());
			
			// for quantity;
			Integer q=plant.getPlantStock()-cart.getQuantity();
			if(q<0) {
				throw new CartException("Sufficient quantity is not avalable");
			}
			plant.setPlantStock(q);
			plantRepository.save(plant);
			
		}else if(cart.getOrderType().toString().equals("SEED")){
			Seed seed=seedRepository.findById(productId).get();
			cart.setDescription("commonName :"+seed.getCommonName()+" bloomTime :"+seed.getBloomTime()+" watering :"+seed.getWatering()+" temperature :"+seed.getTemperature()+" seedsDescription :"+seed.getSeedsDescription());
			
			// for quantity;
			Integer q=seed.getSeedsStock()-cart.getQuantity();
			if(q<0) {
				throw new CartException("Sufficient quantity is not avalable");
			}
			seed.setSeedsStock(q);
			seedRepository.save(seed);
			
		}else if(cart.getOrderType().toString().equals("PLANTERS")) {
			Planter planter =planterRepository.findById(productId).get();
			cart.setDescription(" planterHeight :"+planter.getPlanterHeight()+" planterCapacity :"+planter.getPlanterCapacity()+" drainageHoles :"+planter.getDrainageHoles()+" planterColor :"+planter.getPlanterColor()+" planterShape :"+planter.getPlanterShape());
			
			// for quantity;
			Integer q=planter.getPlanterStock()-cart.getQuantity();
			if(q<0) {
				throw new CartException("Sufficient quantity is not avalable");
			}
			planter.setPlanterStock(q);
			planterRepository.save(planter);
			
		}else if(cart.getOrderType().toString().equals("FERTILIZER")) {
			  Fertilizer fz=fertilizerRepo.findById(productId).get();
			  cart.setDescription(" commonName :"+fz.getCommonName()+" brand :"+fz.getBrand()+" description :"+fz.getDescription()+" quantityPerPacket :"+fz.getQuantityPerPacket()+" brand :"+fz.getBrand());
			  
			// for quantity;
			Integer q=fz.getFertilizerStock()-cart.getQuantity();
			if(q<0) {
				throw new CartException("Sufficient quantity is not avalable");
			}
			fz.setFertilizerStock(q);
			fertilizerRepo.save(fz);
			  
		}else {
			throw new CartException("Product not found with Id :"+productId);
		}
		
		Customer customer=customeropt.get();
		customer.getCart_iteams().add(cart);
		cart.setCustomer_cart(customer);
		
		return cartRepository.save(cart);
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
			
			    if(customer.getCart_iteams().get(i).getCartId().equals(cartId)){
			    	System.out.println(customer.getCart_iteams().get(i).getCartId() +" "+cartId);
			    	cart=customer.getCart_iteams().get(i);
			    	customer.getCart_iteams().remove(i);
			    }
		}
		
		cartRepository.delete(cart);
		
		if(cart==null) {
			throw new CartException("Cart Iteam not Found with id :"+cartId);
		}
		
		customerRepository.save(customer);

		return cart;
		
	}
	
	
}

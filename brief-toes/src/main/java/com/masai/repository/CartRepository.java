package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer>{
        public Cart findByCartId(Integer cartId);
        
}

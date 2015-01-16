package com.tut.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.spring.entities.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {
	
	
}

package com.tut.spring.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.spring.entities.Pizza;
import java.lang.String;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
	
	Pizza findByName(String name);
	
	List<Pizza> findByNameContainingIgnoreCase(String name);
}

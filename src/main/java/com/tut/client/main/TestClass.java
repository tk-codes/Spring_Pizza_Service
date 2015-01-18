package com.tut.client.main;

import com.tut.spring.service.PizzaService;
import com.tut.spring.service.impl.PizzaServiceImpl;

public class TestClass {
	
	private PizzaService pizzaService;
	
	public TestClass(PizzaService serviceImpl) {
		this.pizzaService = serviceImpl;
	}


}

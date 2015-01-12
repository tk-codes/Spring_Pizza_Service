package com.tut.spring.dto;

import java.util.List;

public class OrderDTO {
	
	private Integer id;
	
	private CustomerDTO customer;
	
	private List<PizzaOrderDTO> pizzas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public List<PizzaOrderDTO> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<PizzaOrderDTO> pizzas) {
		this.pizzas = pizzas;
	}

}

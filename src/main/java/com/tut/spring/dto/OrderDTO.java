package com.tut.spring.dto;

import java.util.ArrayList;
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
		if(pizzas == null)
			pizzas = new ArrayList<PizzaOrderDTO>();
		return pizzas;
	}

	public void setPizzas(List<PizzaOrderDTO> pizzas) {
		this.pizzas = pizzas;
	}
	
	public void addPizza(PizzaOrderDTO pizza){
		getPizzas().add(pizza);
		pizza.setOrder(this);
	}
	
	public void removePizza(PizzaOrderDTO pizza){
		getPizzas().remove(pizza);
		pizza.setOrder(null);
	}

}

package com.tut.spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE) 
public class OrderDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private Integer id;
	@JsonProperty
	private CustomerDTO customer;
	@JsonProperty
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
	}
	
	public void removePizza(PizzaOrderDTO pizza){
		getPizzas().remove(pizza);
	}
}

package com.tut.spring.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE) 
public class PizzaOrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Integer id;
	
	private PizzaDTO pizza;

	@JsonProperty
	private int count;
	
	public PizzaOrderDTO(){
		
	}

	public Integer getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PizzaDTO getPizza() {
		return pizza;
	}

	public void setPizza(PizzaDTO pizza) {
		this.pizza = pizza;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}

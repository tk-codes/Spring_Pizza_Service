package com.tut.spring.dto;

import java.io.Serializable;


public class PizzaDTO implements Serializable {

	private Integer id;
	private String name;
	
	private String incredients;
	
	private double price;
	
	public PizzaDTO(){
		
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIncredients() {
		return incredients;
	}

	public void setIncredients(String incredients) {
		this.incredients = incredients;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

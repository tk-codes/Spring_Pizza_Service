package com.tut.spring.dto;


public class PizzaDTO {

	private Integer id;
	private String name;
	
	private String incredients;
	
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
	
	
}

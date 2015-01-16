package com.tut.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private String name;
	
	private String incredients;
	
	private double price;
	
	public Pizza(){
		
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

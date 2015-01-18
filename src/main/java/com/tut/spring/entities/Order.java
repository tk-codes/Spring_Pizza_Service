package com.tut.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_fk")
	private Customer customer;
	
	@OneToMany(/*mappedBy="order", */cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<PizzaOrder> pizzas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PizzaOrder> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<PizzaOrder> pizzas) {
		this.pizzas = pizzas;
	}
}

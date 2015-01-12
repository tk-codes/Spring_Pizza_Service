package com.tut.spring.dto;


public class PizzaOrderDTO {

	private Integer id;
	
	private PizzaDTO pizza;
	
	private OrderDTO order;
	
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

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}

package com.tut.spring.service;

import java.util.List;

import com.tut.spring.dto.OrderDTO;

public interface OrderService {
	
	public Integer createOrder(OrderDTO order);
	public List<OrderDTO> findAllOrders();
	public OrderDTO findOrder(int id);
}

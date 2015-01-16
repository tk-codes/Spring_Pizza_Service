package com.tut.spring.service;

import java.util.List;

import com.tut.spring.dto.OrderDTO;

public interface OrderService {
	
	public OrderDTO create(OrderDTO order);
	public OrderDTO update(OrderDTO order);
	public void delete(Integer id);
	public void deleteAll();
	public List<OrderDTO> findAllOrders();
	public OrderDTO findOne(int id);
}

package com.tut.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tut.spring.dto.EntityDTOMapper;
import com.tut.spring.dto.OrderDTO;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.entities.Order;
import com.tut.spring.entities.Pizza;
import com.tut.spring.entities.PizzaOrder;
import com.tut.spring.repositories.CustomerRepository;
import com.tut.spring.repositories.OrderRepository;
import com.tut.spring.repositories.PizzaRepository;
import com.tut.spring.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private PizzaRepository pizzaRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private EntityDTOMapper mapper;

	@Override
	@Transactional
	public OrderDTO create(OrderDTO order) {
		Order entity = mapToOrder(order);
		orderRepo.save(entity);
		order.setId(entity.getId());
		return order;
	}

	@Override
	@Transactional
	public OrderDTO update(OrderDTO order) {
		Order entity = mapToOrder(order);
		orderRepo.save(entity);
		return order;
	}

	@Override
	public void delete(Integer id) {
		orderRepo.delete(id);
	}

	@Override
	@Transactional
	public List<OrderDTO> findAllOrders() {
		List<Order> orders = orderRepo.findAll();
		List<OrderDTO> dtos = new ArrayList<OrderDTO>();
		for (Order o : orders)
			dtos.add(mapToDTO(o));
		return dtos;
	}

	@Override
	@Transactional
	public OrderDTO findOne(int id) {
		Order order = orderRepo.findOne(id);
		return mapToDTO(order);
	}

	private OrderDTO mapToDTO(Order order) {
		return mapper.map(order, OrderDTO.class);
	}

	private Order mapToOrder(OrderDTO dto) {
		return mapper.map(dto, Order.class);
	}

	@Override
	@Transactional
	public void deleteAll() {
		// List<Order> orders = orderRepo.findAll();
		// for(Order o : orders){
		// for(PizzaOrder p: o.getPizzas()){
		// p.setPizza(null);
		// }
		// }
		orderRepo.deleteAll();
	}
}

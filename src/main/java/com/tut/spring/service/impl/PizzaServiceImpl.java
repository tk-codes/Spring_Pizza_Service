package com.tut.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tut.spring.dto.EntityDTOMapper;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.entities.Pizza;
import com.tut.spring.repositories.PizzaRepository;
import com.tut.spring.service.PizzaService;

@Component
public class PizzaServiceImpl implements PizzaService {

	@Resource
	private PizzaRepository repository;

	@Autowired
	private EntityDTOMapper mapper;

	@Override
	public List<PizzaDTO> findAll() {
		List<Pizza> pizzas = repository.findAll();
		List<PizzaDTO> dtos = new ArrayList<PizzaDTO>();
		for (Pizza p : pizzas)
			dtos.add(mapToDTO(p));
		return dtos;
	}

	@Override
	public PizzaDTO findOne(int id) {
		Pizza p = repository.findOne(id);
		if (p != null) {
			return mapToDTO(p);
		}
		return null;
	}

	@Override
	public PizzaDTO findByName(String name) {
		Pizza pizza = repository.findByName(name);
		if (pizza != null) {
			return mapToDTO(pizza);
		}
		return null;
	}

	@Override
	public List<PizzaDTO> findByNameContainingIgnoreCase(String name) {
		List<Pizza> pizzas = repository.findByNameContainingIgnoreCase(name);
		if (!pizzas.isEmpty()) {
			List<PizzaDTO> dtos = new ArrayList<PizzaDTO>();
			for (Pizza p : pizzas)
				dtos.add(mapToDTO(p));
			
			return dtos;
		}
		return null;
	}

	@Override
	public PizzaDTO create(PizzaDTO pizza) {
		Pizza pizzaEntity = mapToPizza(pizza);
		repository.save(pizzaEntity);
		pizza.setId(pizzaEntity.getId());
		return pizza;
	}

	@Override
	public PizzaDTO update(PizzaDTO pizza) {
		Pizza p = mapToPizza(pizza);
		repository.save(p);
		return pizza;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	private PizzaDTO mapToDTO(Pizza pizza) {
		return mapper.map(pizza, PizzaDTO.class);
	}

	private Pizza mapToPizza(PizzaDTO dto) {
		return mapper.map(dto, Pizza.class);
	}
}

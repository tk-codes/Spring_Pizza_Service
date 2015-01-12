package com.tut.spring.service;

import java.util.List;

import com.tut.spring.dto.PizzaDTO;

public interface PizzaService {
	
	public PizzaDTO create(PizzaDTO pizza);
	public PizzaDTO update(PizzaDTO pizza);
	public void delete(Integer id);
	public List<PizzaDTO> findAll();
	public PizzaDTO findOne(int id);
	public PizzaDTO findByName(String name);
	public List<PizzaDTO> findByNameContainingIgnoreCase(String name);
}

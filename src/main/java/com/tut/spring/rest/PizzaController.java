package com.tut.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.service.PizzaService;

@RestController
@RequestMapping("/pizza_service")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<PizzaDTO> getAll() {
		try {
			return pizzaService.findAll();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(value="/get/")
	public PizzaDTO findOne(){
		return pizzaService.findOne(6);
	}
	
	@RequestMapping(value = "/test")
	public String test(){
		return "test1";
	}
	
	@RequestMapping(value = "/test2")
	public PizzaDTO test2(){
		PizzaDTO p = new PizzaDTO();
		p.setName("test");
		return p;
	}
}

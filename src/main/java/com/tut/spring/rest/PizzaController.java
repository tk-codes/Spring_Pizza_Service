package com.tut.spring.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza_service")
public class PizzaController {

	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}

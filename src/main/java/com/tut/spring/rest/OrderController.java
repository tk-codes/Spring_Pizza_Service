package com.tut.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tut.spring.dto.OrderDTO;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.service.OrderService;

@RestController
@RequestMapping("/order_service")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<OrderDTO> getAll() {
		try {
			List<OrderDTO> data = orderService.findAllOrders();
			return data;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(value="/order/", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public void createOrder(@RequestBody OrderDTO order){
		orderService.create(order);
	}
}

package com.tut.spring;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tut.spring.dto.CustomerDTO;
import com.tut.spring.dto.OrderDTO;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.dto.PizzaOrderDTO;
import com.tut.spring.entities.Pizza;
import com.tut.spring.repositories.PizzaRepository;
import com.tut.spring.service.OrderService;
import com.tut.spring.service.PizzaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-context.xml")
public class DataImport {
	
	@Autowired
	PizzaRepository repository;
	
	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	OrderService orderService;
	
	@Before
	public void beforeTest(){
	}

	@Test
	public void testCreatePizza() {
		orderService.deleteAll();
		
		repository.deleteAll();
		
		PizzaDTO pizza = new PizzaDTO();
		pizza.setName("Formaggi");
		pizza.setIncredients("Tomatensauce, 2X Mozzarella, Feta, Gorgonzola, Reibkäse, Herbes de Provence");
		pizza.setPrice(14.90);
		
		
		PizzaDTO pizza2 = new PizzaDTO();
		pizza2.setName("Margherita");
		pizza2.setIncredients("Tomatensauce, Mozzarella");
		pizza2.setPrice(15.90);
		
		PizzaDTO pizza3 = new PizzaDTO();
		pizza3.setName("Hawaii");
		pizza3.setIncredients("Tomatensauce, 2X Mozzarella, Hinterschinken, Ananas");
		pizza3.setPrice(18.90);
		
		PizzaDTO pizza4 = new PizzaDTO();
		pizza4.setName("Prosciutto Funghi");
		pizza4.setIncredients("Tomatensauce, Mozzarella, Hinterschinken, 2X Champignons");
		pizza4.setPrice(17.90);

		PizzaDTO pizza5 = new PizzaDTO();
		pizza5.setName("Salami Passione");
		pizza5.setIncredients("Tomatensauce, 2X Mozzarella, 2X Salami");
		pizza5.setPrice(18.90);
		

		PizzaDTO pizza6 = new PizzaDTO();
		pizza6.setName("T.Rex");
		pizza6.setIncredients("Tomatensauce, 2X Mozzarella, Hinterschinken, Salami, Rindfleisch ");
		pizza6.setPrice(21.90);
		
		PizzaDTO pizza7 = new PizzaDTO();
		pizza7.setName("Vegetariana");
		pizza7.setIncredients("Tomatensauce, Mozzarella, Champignons, Peperoni, Frische Tomaten, Oliven, Zwiebeln");
		pizza7.setPrice(21.90);
		
		PizzaDTO pizza8 = new PizzaDTO();
		pizza8.setName("Veggie Deluxe");
		pizza8.setIncredients("Tomatensauce, Mozzarella, Babyspinat, Zwiebeln, Peperoni, Knoblauch, Getrocknete Cherrytomaten, Oliven, Herbes de Provence ");
		pizza8.setPrice(25.90);
		
		PizzaDTO pizza9 = new PizzaDTO();
		pizza9.setName("Deluxe");
		pizza9.setIncredients("Tomatensauce, Mozzarella, Salami, Rindfleisch, Champignons, Peperoni, Zwiebeln ");
		pizza9.setPrice(21.90);
		
		pizzaService.create(pizza);
		pizzaService.create(pizza2);
		pizzaService.create(pizza3);
		pizzaService.create(pizza4);	
		pizzaService.create(pizza5);	
		pizzaService.create(pizza6);	
		pizzaService.create(pizza7);	
		pizzaService.create(pizza8);	
		pizzaService.create(pizza9);	
		
		addOrders();
	}

	private void addOrders() {
		CustomerDTO customer = new CustomerDTO();
		customer.setName("Keerthikan Thurairatnam");
		customer.setStreet("Büelhof 5");
		customer.setPlz(8852);
		customer.setPlace("Altendorf");
		//set orders
		
		PizzaDTO margherita = pizzaService.findByName("Margherita");
		PizzaDTO formaggi = pizzaService.findByName("Vegetariana");
		
		PizzaOrderDTO mPizzOrder = new PizzaOrderDTO();
		mPizzOrder.setCount(2);
		mPizzOrder.setPizza(margherita);
		
		PizzaOrderDTO fPizzaOrder = new PizzaOrderDTO();
		fPizzaOrder.setCount(1);
		fPizzaOrder.setPizza(formaggi);
		
		OrderDTO orders = new OrderDTO();
		orders.setCustomer(customer);
		orders.addPizza(mPizzOrder);
		orders.addPizza(fPizzaOrder);
		
		orderService.create(orders);		
	}
	

	
}

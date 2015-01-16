package com.tut.spring;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tut.spring.dto.CustomerDTO;
import com.tut.spring.dto.OrderDTO;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.dto.PizzaOrderDTO;
import com.tut.spring.repositories.OrderRepository;
import com.tut.spring.repositories.PizzaOrderRepository;
import com.tut.spring.repositories.PizzaRepository;
import com.tut.spring.service.OrderService;
import com.tut.spring.service.PizzaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-context.xml")
public class OrderServiceTest {
	
	@Autowired
	PizzaRepository pizzaRepo;
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	PizzaOrderRepository pzRepo;
	
	@Autowired
	OrderService orderService;

	@Autowired
	PizzaService pizzaService;
	
	@BeforeClass
	public static void setup(){
	}
	
	@Before
	public void beforeTest(){
		if(pizzaRepo.count()==0){
			fillDummyData();
		}
		orderService.deleteAll();
	}

	@Test
	public void testCreateOrder() {
		CustomerDTO customer = new CustomerDTO();
		customer.setName("Keerthikan Thurairatnam");
		customer.setStreet("Büelhof 5");
		customer.setPlz(8852);
		customer.setPlace("Altendorf");
		//set orders
		
		PizzaDTO margherita = pizzaService.findByName("Margherita");
		PizzaDTO formaggi = pizzaService.findByName("Formaggi");
		
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
		
		Assert.assertNotNull(orders.getId());
	}	
	
	@Test
	public void testFindOne() {
		int orderId = createOrder();
		
		OrderDTO order = orderService.findOne(orderId);
		Assert.assertNotNull(order);
	}
	
	@Test
	public void testUpdate() {
		int orderId = createOrder();
		
		OrderDTO order = orderService.findOne(orderId);
		order.getCustomer().setName("Keerthikan 2");
		orderService.update(order);
		
		OrderDTO found = orderService.findOne(orderId);
		Assert.assertEquals(order.getCustomer().getName(), found.getCustomer().getName());
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testDelete() {
		int orderId = createOrder();
		
		OrderDTO order = orderService.findOne(orderId);
		orderService.delete(order.getId());
		
		OrderDTO found = orderService.findOne(orderId);
	}
	
	@Test
	public void testFindAll() {
		int orderId = createOrder();
		
		Assert.assertTrue(orderService.findAllOrders().size()==1);
	}
	
	private void fillDummyData(){
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
		
		pizzaService.create(pizza);
		pizzaService.create(pizza2);
		pizzaService.create(pizza3);
		pizzaService.create(pizza4);		
	}
	
	private Integer createOrder(){
		CustomerDTO customer = new CustomerDTO();
		customer.setName("Keerthikan Thurairatnam");
		customer.setStreet("Büelhof 5");
		customer.setPlz(8852);
		customer.setPlace("Altendorf");
		//set orders
		
		PizzaDTO margherita = pizzaService.findByName("Margherita");
		PizzaDTO formaggi = pizzaService.findByName("Formaggi");
		
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
		return orders.getId();
	}
}

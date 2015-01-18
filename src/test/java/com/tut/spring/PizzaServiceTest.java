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

import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.entities.Pizza;
import com.tut.spring.repositories.PizzaRepository;
import com.tut.spring.service.PizzaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-context.xml")
public class PizzaServiceTest {
	
	@Autowired
	PizzaRepository repository;
	
	@Autowired
	private PizzaService pizzaService;
	
	@Before
	public void beforeTest(){
		repository.deleteAll();
	}

	@Test
	public void testCreatePizza() {
		
		PizzaDTO pizza = new PizzaDTO();
		pizza.setName("Margherita");
		pizza.setIncredients("Tomatensauce, Mozzarella");
		
		pizzaService.create(pizza);		
		Assert.assertNotNull(pizza.getId());
		Assert.assertTrue(repository.count()==1);
	}
	
	@Test
	public void testCreatePizzas() {
		
		PizzaDTO pizza = new PizzaDTO();
		pizza.setName("Margherita");
		pizza.setIncredients("Tomatensauce, Mozzarella");
		
		PizzaDTO pizza2 = new PizzaDTO();
		pizza2.setName("Formaggi");
		pizza2.setIncredients("Tomatensauce, 2X Mozzarella, Feta, Gorgonzola, Reibkäse, Herbes de Provence");
		
		pizzaService.create(pizza);		
		pizzaService.create(pizza2);		
		Assert.assertTrue(repository.count()==2);
	}
	
	
	
	@Test
	public void testUpdate() {
		
		PizzaDTO pizza = new PizzaDTO();
		pizza.setName("Formaggi");
		pizza.setIncredients("Tomatensauce, 2X Mozzarella, Feta, Gorgonzola, Reibkäse, Herbes de Provence");
		
		pizzaService.create(pizza);		
		pizza.setIncredients("Tomatensauce, 3X Mozzarella, Feta, Gorgonzola, Reibkäse, Herbes de Provence");
		pizzaService.update(pizza);
		Pizza p = repository.findOne(pizza.getId());
		Assert.assertEquals(p.getIncredients(), pizza.getIncredients());
	}
	
	@Test
	public void testFindByName() {
		
		PizzaDTO pizza = new PizzaDTO();
		pizza.setName("Formaggi");
		pizza.setIncredients("Tomatensauce, 2X Mozzarella, Feta, Gorgonzola, Reibkäse, Herbes de Provence");
		
		PizzaDTO pizza2 = new PizzaDTO();
		pizza2.setName("Margherita");
		pizza2.setIncredients("Tomatensauce, Mozzarella");
		
		pizzaService.create(pizza);	
		pizzaService.create(pizza2);
				
		Assert.assertTrue(repository.count()==2);
		
		
		PizzaDTO found = pizzaService.findByName("Formaggi");		
		Assert.assertEquals(pizza.getIncredients(), found.getIncredients());
		
		List<PizzaDTO> dtos = pizzaService.findByNameContainingIgnoreCase("gg");
		Assert.assertEquals(pizza.getIncredients(),dtos.get(0).getIncredients());
		
		pizzaService.delete(pizza2.getId());
		Assert.assertTrue(repository.count()==1);
	}
	
}

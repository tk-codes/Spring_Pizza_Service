package com.tut.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tut.spring.dto.CustomerDTO;
import com.tut.spring.dto.EntityDTOMapper;
import com.tut.spring.dto.OrderDTO;
import com.tut.spring.entities.Customer;
import com.tut.spring.entities.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-context.xml")
public class MapperTest {
	
	@Test
	public void testCustomerToDTO() {
		
		Customer customer = new Customer();
		customer.setName("Keerthikan");
		customer.setPlace("Altendorf");
		
		EntityDTOMapper mapper = new EntityDTOMapper();
		CustomerDTO dto = mapper.map(customer, CustomerDTO.class);
		assertNotNull(dto);
		
		assertNotEquals(dto, customer);
		assertEquals(customer.getName(), dto.getName());
	}
	
	@Test
	public void testOrderCustomerDTO(){
		Customer customer = new Customer();
		customer.setName("Keerthikan");
		customer.setPlace("Altendorf");
		
		Order order = new Order();
		order.setCustomer(customer);
		
		EntityDTOMapper mapper = new EntityDTOMapper();
		OrderDTO dto = mapper.map(order, OrderDTO.class);
		
		CustomerDTO cDTO = dto.getCustomer();
		assertNotEquals(cDTO, customer);
	}
}

package com.tut.spring;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tut.spring.repositories.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-context.xml")
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repository;

	@Test
	public void test() {
		assertTrue(true);
	}
}

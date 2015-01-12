package com.tut.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.spring.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

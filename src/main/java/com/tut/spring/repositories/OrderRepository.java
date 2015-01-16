package com.tut.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

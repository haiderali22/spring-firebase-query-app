package com.hali.leaning.spring.firebase.service;

import org.springframework.stereotype.Service;

import com.hali.leaning.spring.firebase.model.Order;
import com.hali.leaning.spring.firebase.repository.OrderRepository;
import reactor.core.publisher.Mono;

@Service
public class OrderService 
{
	OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) 
	{
		this.orderRepository = orderRepository;
	}

	public Mono<Order> findByID(String id) {
		return orderRepository.findById(id);
	}
}

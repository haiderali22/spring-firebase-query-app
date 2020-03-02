package com.hali.leaning.spring.firebase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.hali.leaning.spring.firebase.model.LocationHistory;
import com.hali.leaning.spring.firebase.model.Order;
import com.hali.leaning.spring.firebase.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
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
	
	public List<LocationHistory> findAllLocationHistoryByOrderID(String id)  
	{		
		return orderRepository.findAllLocationHistoryByOrderID(id);
	}
	
	public Flux<LocationHistory> findAllLocationHistoryByOrderIDFlux(String id)  
	{		
		return orderRepository.findAllLocationHistoryByOrderIDFlux(id);
	}
	
	
}

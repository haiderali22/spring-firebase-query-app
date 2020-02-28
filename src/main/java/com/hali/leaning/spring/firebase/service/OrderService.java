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

import com.hali.leaning.spring.firebase.model.Order;
import com.hali.leaning.spring.firebase.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OrderService 
{
	OrderRepository orderRepository;
	
	@Autowired
	Firestore firestore;

	public OrderService(OrderRepository orderRepository) 
	{
		this.orderRepository = orderRepository;
	}

	public Mono<Order> findByID(String id) {
		return orderRepository.findById(id);
	}
	
	public List<Map<String,Object>> findByIDFireStore(String id) 
	{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		CollectionReference locHistory = 
				firestore.collection("Orders").
				document(id).
				collection("LocationHistory");
		
		Iterable<DocumentReference> docIterator = 
				locHistory.listDocuments();
		
		docIterator.forEach( d -> {
			try {
				list.add( d.get().get().getData());
			} catch (InterruptedException | ExecutionException e) {
				log.debug(e.getMessage());
			}			
		});
		
		return list;
	}
}

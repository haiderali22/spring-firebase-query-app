package com.hali.leaning.spring.firebase.repository;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

import com.hali.leaning.spring.firebase.model.Order;


public interface OrderRepository  extends  FirestoreReactiveRepository<Order> 
{
	
}

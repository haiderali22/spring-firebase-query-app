package com.hali.leaning.spring.firebase.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

import com.hali.leaning.spring.firebase.model.LocationHistory;
import com.hali.leaning.spring.firebase.model.Order;

import reactor.core.publisher.Flux;


public interface OrderRepository  extends  FirestoreReactiveRepository<Order> 
{
	List<LocationHistory> findAllLocationHistoryByOrderID(String id);
	Flux<LocationHistory> findAllLocationHistoryByOrderIDFlux(String id);
}

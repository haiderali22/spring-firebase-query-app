package com.hali.leaning.spring.firebase.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.cloud.gcp.data.firestore.FirestoreDataException;
import org.springframework.cloud.gcp.data.firestore.FirestoreTemplate;
import org.springframework.cloud.gcp.data.firestore.SimpleFirestoreReactiveRepository;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.hali.leaning.spring.firebase.model.LocationHistory;
import com.hali.leaning.spring.firebase.model.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class OrderRepositoryImpl  extends SimpleFirestoreReactiveRepository<Order> implements  OrderRepository 
{
	private Firestore firestore;

	public OrderRepositoryImpl(FirestoreTemplate firestoreTemplate,Firestore firestore) 
	{	
		super(firestoreTemplate, Order.class);
		this.firestore = firestore;
	}

	@Override
	public Flux<LocationHistory> findAllLocationHistoryByOrderIDFlux(String id)
	{
		throw new NotImplementedException("");
	}
	

	@Override
	public List<LocationHistory> findAllLocationHistoryByOrderID(String id) 
	{
		List<LocationHistory> list = new ArrayList<LocationHistory>();
		
		//CollectionReference locHistory = 
				try {
					firestore.collection("Orders").
					document(id).
					collection("LocationHistory").get().get().getDocuments().
					forEach( d -> list.add( d.toObject(LocationHistory.class)));
				} catch (InterruptedException | ExecutionException e) {
					throw new FirestoreDataException("Error while reading entries by id", e);
				}

		
		return list;
	}
	
	
}

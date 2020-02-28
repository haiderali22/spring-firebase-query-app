package com.hali.leaning.spring.firebase.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hali.leaning.spring.firebase.service.OrderService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class QueryController 
{
	private OrderService orderService;

	public QueryController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping(value="/query/order/{id}")
	public ResponseEntity queryOrderById(@PathVariable String id)
	{
		 return ResponseEntity
	                .ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(Mono.just(orderService.findByID(id).toProcessor().blockOptional().get()));		 	
	}
	
	@GetMapping(value="simple/query/order/{id}")
	public ResponseEntity queryOrderByIdSimple(@PathVariable String id)
	{
		 return ResponseEntity
	                .ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(orderService.findByIDFireStore(id));		 	
	}
	
}

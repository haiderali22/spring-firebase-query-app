package om.hali.leaning.spring.firebase.service;

import om.hali.leaning.spring.firebase.model.Order;
import om.hali.leaning.spring.firebase.repository.OrderRepository;
import reactor.core.publisher.Mono;

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

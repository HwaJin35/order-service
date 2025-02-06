package com.polarbookshop.orderservice.order.domain;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	// 플럭스는 여러 개의 주문을 위해 사용된다.(0..N) 비동기 시퀀스.
	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	// ReactiveCrudRepository에서 제공하는 save()메서드 노출.
	// 주문을 데이터베이스에 저장하기 위해 리액티브 스트림을 만들어 Mono<Order> 객체 유형으로 전달.
	// 자바 스트림 Stream.of() 객체 생성 방식으로 Mono.just()로 모노 객체 생성.
	public Mono<Order> submitOrder(String isbn, int quantity) {
		return Mono.just(buildRejectedOrder(isbn, quantity))		// 주문 객체를 가지고 모노를 생성.
				.flatMap(orderRepository::save);	// 리액티브 스트림의 앞 단계에서 비동기적으로 생성된 주문 객체를 데이터베이스에 저장.
	}

	public static Order buildRejectedOrder(
			String bookIsbn, int quantity
			) {	
		// 주문이 거부되면 ISBN, 수량 상태만 지정한다.
		// 스프링 데이터가 식별자, 버전, 감사 메타데이터를 알아서 처리해준다.
		return Order.of(bookIsbn, null, null, quantity, OrderStatus.REJECTED);
	}

}

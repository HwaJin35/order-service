package com.polarbookshop.orderservice.order.web;

import org.springframework.web.bind.annotation.*;

import com.polarbookshop.orderservice.order.domain.Order;
import com.polarbookshop.orderservice.order.domain.OrderService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public Flux<Order> getAllOrders() {		// 플럭스는 여러 개의 객체를 위해 사용된다.
		return orderService.getAllOrders();
	}

	@PostMapping
	public Mono<Order> submitOrder(		// OrderRequest 객체를 받아서 유효성 검증을 하고 주문을 생성.
										// 생성한 주문은 모노로 반환
			@RequestBody @Valid OrderRequest orderRequest
			) {
		return orderService.submitOrder(
				orderRequest.isbn(), orderRequest.quantity()
				);
	}
}

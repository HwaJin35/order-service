package com.polarbookshop.orderservice.order.domain;

public enum OrderStatus {
	ACCEPTED,		// 주문 요청 접수
	REJECTED,		// 주문 요청 거부
	DISPATCHED		// 배송
}

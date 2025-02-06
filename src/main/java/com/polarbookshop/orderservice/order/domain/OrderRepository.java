package com.polarbookshop.orderservice.order.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// CRUD 연산을 제공하는 리액티브 리포지터리가 관리할 엔터티의 유형(Order)과 
// 해당 엔터티의 기본 키 유형(Long)을 지정하고 확장.
public interface OrderRepository extends ReactiveCrudRepository<Order,Long> {
}

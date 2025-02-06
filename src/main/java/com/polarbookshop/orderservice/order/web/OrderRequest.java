package com.polarbookshop.orderservice.order.web;

import jakarta.validation.constraints.*;

// 유효성 검증 제약 조건이 정의된 DTO 클래스
public record OrderRequest (

	@NotBlank(message = "The book ISBN must be defined.")
	String isbn,

	@NotNull(message = "The book quantity must be defined.")
	@Min(value = 1, message = "You must order at least 1 item.")
	@Max(value = 5, message = "You cannot order more than 5 items.")
	Integer quantity

){}

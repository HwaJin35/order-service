package com.polarbookshop.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration				// 스프링 설정을 위한 클래스.
@EnableR2dbcAuditing		// 지속성 엔터티에 대한 R2DBC Auditing 활성화.
public class DataConfig {
}

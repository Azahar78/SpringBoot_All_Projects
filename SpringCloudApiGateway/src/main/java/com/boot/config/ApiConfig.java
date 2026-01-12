package com.boot.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

	@Bean
	public RouteLocator gateConfig(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("cart-id",cart->cart.path("/cart/**").uri("lb://CART-SERVICE"))
				.route("order-id",order->order.path("/order/**").uri("lb://ORDER-SERVICE"))
				.build();
	}
}

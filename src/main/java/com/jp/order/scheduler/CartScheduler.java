package com.jp.order.scheduler;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jp.order.service.CartService;
import com.jp.order.vo.Cart;

@Component
public class CartScheduler {

	@Autowired
	private CartService service;
	
	//@Scheduled(fixedRate = 1000)
	public void submitCart() {
		Cart cart = new Cart();
		cart.setOrderId(UUID.randomUUID().toString());
		service.submitCart(cart);
	}
}

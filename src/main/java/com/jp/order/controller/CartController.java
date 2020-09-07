package com.jp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.order.service.CartService;
import com.jp.order.vo.Cart;
import com.jp.order.vo.Product;

@RestController
public class CartController {
	
	@Autowired
	private CartService service;

	@PostMapping("/carts/submit")
	public String submit(@RequestBody Cart cart) {
		return service.submitCart(cart);
	}
	
	@PostMapping("/products/submit")
	public String submit(@RequestBody Product product) {
		return service.publishProduct(product);
	}
}

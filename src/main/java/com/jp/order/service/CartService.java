package com.jp.order.service;

import java.util.UUID;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.order.vo.Cart;
import com.jp.order.vo.GenericPayload;
import com.jp.order.vo.Product;

@Service
public class CartService {
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public String submitCart(Cart cart) {
		String orderId = UUID.randomUUID().toString();
		cart.setOrderId(orderId);
		try {
			GenericPayload<Cart> payload = new GenericPayload<>();
			payload.setChannel("CART");
			payload.setPayload(cart);
			kafkaTemplate.send("orders", mapper.writeValueAsString(cart));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return orderId;
	}
	
	public String publishProduct(Product product) {
		String productId = UUID.randomUUID().toString();
		product.setId(productId);
		try {
			GenericPayload<Product> payload = new GenericPayload<>();
			payload.setChannel("PRODUCT");
			payload.setPayload(product);
			kafkaTemplate.send("products", mapper.writeValueAsString(payload));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return productId;
	}
}

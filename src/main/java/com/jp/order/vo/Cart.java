package com.jp.order.vo;

import java.util.List;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

	private String email;
	private Address shippingAddress;
	private Address billingAddress;
	private Cost charges;
	private Discounts discounts;
	private String orderId;
	private List<Item> items;
}

package com.jp.order.vo;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cost {

	private BigDecimal subtotal;
	private BigDecimal tax;
	private BigDecimal shipping;
	private BigDecimal total;
}

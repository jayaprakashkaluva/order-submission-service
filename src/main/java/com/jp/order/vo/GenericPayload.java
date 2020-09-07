package com.jp.order.vo;

import lombok.Data;

@Data
public class GenericPayload<T> {
 private String channel;
 private T payload;
}

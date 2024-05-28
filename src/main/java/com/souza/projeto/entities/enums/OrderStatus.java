package com.souza.projeto.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	shipped(3),
	DELIVERED(4),
	CANCELED(5);
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus i : OrderStatus.values()) {
			if(i.getCode() == code) {
				return i;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status code!");
	}
}

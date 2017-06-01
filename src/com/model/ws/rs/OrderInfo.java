package com.model.ws.rs;

import com.model.ws.WSResult;

public class OrderInfo extends WSResult {
	private String orderNum;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

}

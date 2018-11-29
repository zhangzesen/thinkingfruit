package com.thinkingFruit.client.service;

import javax.servlet.http.HttpServletRequest;

import com.thinkingFruit.client.entity.ClientPurchaseOrder;

public interface PurchaseOrderService {

	void addPurchaseOrder(HttpServletRequest request, ClientPurchaseOrder clientPurchaseOrder);
	
}

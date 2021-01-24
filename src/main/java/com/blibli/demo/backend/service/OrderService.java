package com.blibli.demo.backend.service;

import com.blibli.demo.backend.controller.model.request.InsertOrderRequest;
import com.blibli.demo.backend.entity.Order;

import java.util.List;


public interface OrderService {
    public List<Order> getOrders();
    public Order getOrderById(int id);
    public Order insertOrder(InsertOrderRequest orderRequest);
}

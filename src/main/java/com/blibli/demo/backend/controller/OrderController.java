package com.blibli.demo.backend.controller;

import com.blibli.demo.backend.controller.model.request.InsertOrderRequest;
import com.blibli.demo.backend.entity.Order;
import com.blibli.demo.backend.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders () {
        List<Order> listOrder = orderService.getOrders();
        return listOrder;
    }

    @GetMapping(value = "/orders/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById (@PathVariable int orderId) {
        Order order = orderService.getOrderById(orderId);
        return order;
    }

    @PostMapping(value = "/orders",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Order submitOrder (@RequestBody InsertOrderRequest orderRequest) {
        Order order = orderService.insertOrder(orderRequest);
        return order;
    }
}

package com.blibli.demo.backend.service.impl;

import com.blibli.demo.backend.controller.model.request.InsertOrderRequest;
import com.blibli.demo.backend.entity.Order;
import org.springframework.stereotype.Service;
import com.blibli.demo.backend.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private List<Order> listOrder = new ArrayList<Order>();
    private int id = 0;

    @Override
    public List<Order> getOrders() {
        return listOrder;
    }

    @Override
    public Order getOrderById(int id) {
        return listOrder.get(id);
    }

    @Override
    public Order insertOrder(InsertOrderRequest orderRequest) {
        double totalHarga = 0;
        int productId = 0;
        for (int i = 0; i<orderRequest.getListProducts().size(); ++i){
            totalHarga+=orderRequest.getListProducts().get(i).getPrice()*orderRequest.getListProducts().get(i).getQuantity();
            orderRequest.getListProducts().get(i).setId(productId++);
        }
        Order newOrder = Order
                .builder()
                .customer(orderRequest.getCustomer())
                .listProducts(orderRequest.getListProducts())
                .totalPrice(totalHarga)
                .id(id++)
                .build();
        listOrder.add(newOrder);
        return newOrder;
    }
}

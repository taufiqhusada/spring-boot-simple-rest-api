package com.blibli.demo.backend.controller.model.response;

import com.blibli.demo.backend.entity.Customer;
import com.blibli.demo.backend.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private int id;
    private List<Product> listProducts;
    private double totalPrice;
    private Customer customer;
}

package com.blibli.demo.backend.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    private List<Product> listProducts;
    private double totalPrice;
    private Customer customer;
    private int id;
}

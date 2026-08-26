package com.example.warehouse.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public String CreateOrder(Order order) {
        orderRepository.save(order);

        return "Order " + order.getId() + " added.";
    }

    public List<Order> GetOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);

        return orders;
    }
}

package com.example.warehouse.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    @Autowired
    OrderLineRepository orderLineRepository;

    public String CreateOrderLine(OrderLine orderline) {
        orderLineRepository.save(orderline);

        return "OrderLine " + orderline.getId() + " added.";
    }

    public List<OrderLine> GetOrderLines() {
        List<OrderLine> orderlines = new ArrayList<>();
        orderLineRepository.findAll().forEach(orderlines::add);

        return orderlines;
    }
}

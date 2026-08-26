package com.example.warehouse.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFacade {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderLineRepository orderLineRepository;

    public Order createOrder(Order order) {
        orderRepository.save(order);

        return order;
    }

    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);

        return orders;
    }

    public Order getOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        }

        throw new RuntimeException("Order id not found: " + id);

    }

    public Order updateOrder(Long id, Order order) {
        order.setId(id);
        orderRepository.save(order);

        return order;
    }

    public OrderLine createOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);

        return orderLine;
    }

    public List<OrderLine> getOrderLines() {
        List<OrderLine> orderlines = new ArrayList<>();
        orderLineRepository.findAll().forEach(orderlines::add);

        return orderlines;
    }

    public OrderLine getOrderLine(Long id) {
        Optional<OrderLine> optionalOrderLine = orderLineRepository.findById(id);
        if (optionalOrderLine.isPresent()) {
            return optionalOrderLine.get();
        }

        throw new RuntimeException("OrderLine id not found: " + id);

    }

    public OrderLine updateOrderLine(Long id, OrderLine orderLine) {
        orderLine.setId(id);
        orderLineRepository.save(orderLine);
        return orderLine;

    }

    public Order addOrderLineToOrder(Long orderId, Long orderLineId) {
        // fetch order and order lines
        Order order = getOrder(orderId);
        OrderLine orderLine = getOrderLine(orderLineId);
        // update
        orderLine.addToOrder(order);
        // save
        orderLineRepository.save(orderLine);
        orderRepository.save(order);

        return order;
    }

}

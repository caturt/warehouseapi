package com.example.warehouse.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource {

    private final OrderFacade orderFacade;

    public OrderResource(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderFacade.getOrder(id);

    }

    @GetMapping
    public List<Order> geAllOrders() {
        return orderFacade.getOrders();
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return orderFacade.createOrder(order);
    }

    @GetMapping("/orderLines/{id}")
    public OrderLine getOrderLineById(@PathVariable Long id) {
        return orderFacade.getOrderLine(id);

    }

    @GetMapping("/orderLines")
    public List<OrderLine> geAllOrderLines() {
        return orderFacade.getOrderLines();
    }

    @PostMapping("/createOrderLine")
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderFacade.createOrderLine(orderLine);
    }

    @PutMapping("/{id}/orderline/{orderLineId}")
    public Order addOrderLineToOrder(@PathVariable Long id, @PathVariable Long orderLineId) {

        return orderFacade.addOrderLineToOrder(id, orderLineId);
    }

}

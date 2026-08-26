package com.example.warehouse.order;

import com.example.warehouse.employee.Employee;
import com.example.warehouse.inventory.Item;
import com.example.warehouse.inventory.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERLINE_ID")
    private Long id;
    @Column(name = "ORDERLINE_QTY")
    private int quantity;
    @Column(name = "ORDERLINE_QTY_PICKED")
    private int quantityPicked;
    @Column(name = "ORDERLINE_ISCOMPLETE")
    private boolean isComplete;
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee pickedBy;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    protected OrderLine() {
    }

    public OrderLine(int quantity, boolean isComplete, Item item) {
        this.quantity = quantity;
        this.isComplete = isComplete;
        this.item = item;
    }

    public void addToOrder(Order order) {
        order.addOrderLine(this);
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityPicked() {
        return quantityPicked;
    }

    public void setQuantityPicked(int quantityPicked) {
        this.quantityPicked = quantityPicked;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(Employee pickedBy) {
        this.pickedBy = pickedBy;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
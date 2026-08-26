package com.example.warehouse.inventory;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private long id;
    @NotNull
    @Column(name = "ITEM_SKU")
    private String sku;
    @NotNull
    @Column(name = "ITEM_NAME")
    private String name;
    @Column(name = "ITEM_BOXQTY")
    private int boxQty;
    @Column(name = "ITEM_CASEQTY")
    private int caseQty;
    @OneToMany(mappedBy = "item")
    private List<Location> locations;

    public Item(String sku, String name, int boxQty, int caseQty) {
        this.sku = sku;
        this.name = name;
        this.boxQty = boxQty;
        this.caseQty = caseQty;
    }

    protected Item() {
    }

    public String getSku() {
        return sku;
    }

    @Column(nullable = false)
    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public void setName(String name) {
        this.name = name;
    }

    public int getBoxQty() {
        return boxQty;
    }

    public void setBoxQty(int boxQty) {
        this.boxQty = boxQty;
    }

    public int getCaseQty() {
        return caseQty;
    }

    public void setCaseQty(int caseQty) {
        this.caseQty = caseQty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
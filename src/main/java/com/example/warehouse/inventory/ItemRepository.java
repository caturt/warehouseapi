package com.example.warehouse.inventory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findById(long id);

    List<Item> findByName(String name);

}

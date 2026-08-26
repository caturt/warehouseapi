package com.example.warehouse.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public String CreateItem(Item item) {
        itemRepository.save(item);

        return "Item " + item.getName() + " added.";
    }

    public List<Item> GetEmployees() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);

        return items;
    }
}

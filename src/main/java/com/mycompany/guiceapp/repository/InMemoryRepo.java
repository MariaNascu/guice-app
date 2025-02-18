package com.mycompany.guiceapp.repository;

import com.mycompany.guiceapp.model.Item;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepo implements GuiceToDoRepository {
    private final Item item;
    private final Map<Integer, Map<Integer, String>> database = new HashMap<>();

    @Inject
    public InMemoryRepo(Item item) {
        this.item = item;
    }

    @Override
    public void addItem(Item newItem) {
        item.setQuantity(newItem.getQuantity());
        item.setName(newItem.getName());
        item.setId(newItem.getId());

        database.put(item.getId(), Map.of(item.getQuantity(), item.getName()));
    }

    @Override
    public Map<Integer, Map<Integer, String>> getAllItems() {
        return database;
    }

    @Override
    public void deleteItem(Integer id) {
        database.remove(id);
    }
}

package com.mycompany.guiceapp.repository;

import com.mycompany.guiceapp.model.Item;

import java.util.Map;

public interface GuiceToDoRepository {
    void addItem(Item item);
    Map<Integer,Map<Integer, String>> getAllItems();
    void deleteItem(Integer id);
}

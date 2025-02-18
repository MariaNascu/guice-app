package com.mycompany.guiceapp.service;

import com.mycompany.guiceapp.model.Item;
import com.mycompany.guiceapp.repository.GuiceToDoRepository;
import jakarta.inject.Inject;

import java.util.Map;

public class GuiceToDoService {
    private final GuiceToDoRepository repository;

    @Inject
    public GuiceToDoService(GuiceToDoRepository guiceToDoRepository){
        this.repository=guiceToDoRepository;
    }

    public Map<Integer,Map<Integer, String>> getAll(){
       return repository.getAllItems();
    }

    public void add(Item item){
        repository.addItem(item);
    }

    public void delete(Integer id){
        repository.deleteItem(id);
    }
}

package com.mycompany.guiceapp.module;

import com.google.inject.AbstractModule;
import com.mycompany.guiceapp.controller.JerseyToDoController;
import com.mycompany.guiceapp.repository.GuiceToDoRepository;
import com.mycompany.guiceapp.repository.InMemoryRepo;
import com.mycompany.guiceapp.service.GuiceToDoService;

public class ToDoModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(GuiceToDoRepository.class).to(InMemoryRepo.class);
        bind(GuiceToDoService.class);
        bind(JerseyToDoController.class);
    }
}

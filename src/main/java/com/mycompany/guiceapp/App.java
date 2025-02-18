package com.mycompany.guiceapp;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.guiceapp.controller.JerseyToDoController;
import com.mycompany.guiceapp.feature.GuiceFeature;
import com.mycompany.guiceapp.module.ToDoModule;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Injector injector = Guice.createInjector(new ToDoModule());
        ResourceConfig config = new ResourceConfig().register(GuiceFeature.class)
                .register(injector.getInstance(JerseyToDoController.class));
        URI base = URI.create("http://localhost:8085/");
        Server server = JettyHttpContainerFactory.createServer(base, config);

        System.out.println("Server running at " + base);
        server.join();

    }
}
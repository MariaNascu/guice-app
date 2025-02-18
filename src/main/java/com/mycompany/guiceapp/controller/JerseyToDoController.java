package com.mycompany.guiceapp.controller;

import com.mycompany.guiceapp.model.Item;
import com.mycompany.guiceapp.service.GuiceToDoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JerseyToDoController {
    private final GuiceToDoService service;

    @Inject
    public JerseyToDoController(GuiceToDoService guiceToDoService) {
        this.service = guiceToDoService;
    }

    @GET
    public Response getAllItems() {
        Map<Integer,Map<Integer, String>> items = service.getAll();
        return Response.ok(items).build();
    }

    @POST
    @Path("/add")
    public Response addItem(Item item) {
        service.add(item);
        return Response.status((Response.Status.CREATED)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") Integer itemId) {
        service.delete(itemId);
        return Response.noContent().build();
    }
}

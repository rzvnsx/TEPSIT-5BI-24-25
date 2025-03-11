package com.example.helloweb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
public class ItemService {
    private static List<String> items = DataManager.loadData();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getItems() {
        return items;
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void addItem(String item) {
        items.add(item);
        DataManager.saveData(items);
    }

    @DELETE
    public void clearItems() {
        items.clear();
        DataManager.saveData(items);
    }
}
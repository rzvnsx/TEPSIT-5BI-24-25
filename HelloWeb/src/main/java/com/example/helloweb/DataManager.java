package com.example.helloweb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_NAME = "data.json";
    private static Gson gson = new Gson();

    public static void saveData(List<String> data) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadData() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>(); // Se il file non esiste, restituisce una lista vuota
        }
    }
}
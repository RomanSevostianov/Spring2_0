package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.services.FileService;
import com.example.recipe2_0.services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientService {

    private long counter = 0;
    public Map<Long, Ingredients> ingredient = new LinkedHashMap<>();

    final private FileService fileService;

    public IngredientsServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public Ingredients getIngredients(long id) {
        return ingredient.get(id);
    }

    @Override
    public long postIngredients(Ingredients ingredients) {
        ingredient.put(counter, ingredients);
        saveFile();
        return counter++;
    }

    @Override
    public Ingredients putIngredients(long id, Ingredients ingredients) {
        if (ingredient.containsKey(id)) {
            return ingredient.put(id, ingredients);
        }
        saveFile();
        return null;
    }

    @Override
    public Ingredients deleteIngredients(long id) {
        if (ingredient.containsKey(id)) {
            return ingredient.remove(id);
        }
        return null;
    }


    private void readFile() {
        String json =fileService.readFile();
        try {
           ingredient= new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Long,Ingredients>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredient);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

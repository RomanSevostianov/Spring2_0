package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.FileService;
import com.example.recipe2_0.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class RecipeServiceImpl implements RecipeService {

    final private FileService fileService;
    public Map<Long, Recipe> recipeService = new LinkedHashMap<>();
    long counter = 0;

    public RecipeServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }


    @Override
    public Recipe getRecipe(long id) {
        return recipeService.get(id);
    }

    @Override
    public long postRecipe(Recipe recipe) {
        recipeService.put(counter, recipe);
        return counter++;
    }

    @Override
    public Recipe putRecipe(long id, Recipe recipe) {
        if (recipeService.containsKey(id)) {
            return recipeService.put(id, recipe);
        }
        return null;
    }

    @Override
    public Recipe deleteRecipe(long id) {
        if (recipeService.containsKey(id)) {
            recipeService.remove(id);
        }
        return null;
    }

    private void readFile() {
        String json = fileService.readFile();
        try {
            recipeService = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeService);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

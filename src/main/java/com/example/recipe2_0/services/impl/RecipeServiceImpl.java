package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class RecipeServiceImpl implements RecipeService {

public Map<Long, Recipe> recipeService = new LinkedHashMap<>();
        long counter=0;
    @Override
    public Recipe getRecipe(long id) {
       return recipeService.get(id);
    }

    @Override
    public long postRecipe(Recipe recipe) {
        recipeService.put(counter,recipe);
        return counter++;
    }

    @Override
    public Recipe putRecipe(long id, Recipe recipe) {
        if (recipeService.containsKey(id)){
        return recipeService.put(id,recipe);
        }
        return  null;
    }

    @Override
    public Recipe deleteRecipe(long id) {
        if (recipeService.containsKey(id)){
            recipeService.remove(id);
        }
       return null;
    }
}

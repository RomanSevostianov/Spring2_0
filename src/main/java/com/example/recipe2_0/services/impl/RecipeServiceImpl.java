package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class RecipeServiceImpl implements RecipeService {
    private static int counter = 0;
    private final Map<Integer, Recipe> recipes = new LinkedHashMap<>();

    @Override
    public Recipe getRecipe(int number) {
        return recipes.get(number);
    }

    @Override
    public int addRecipe(Recipe recipe) {
        recipes.put(counter++, recipe);
        return counter;
    }
    @Override
    public Recipe removeRecipe(int number) {
        return recipes.remove(number);

    }
}

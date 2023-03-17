package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;


@Service
public class RecipeServiceImpl implements RecipeService {

    public static int lastIdRecipe = 0;
    public static int lastIdIngrediens = 0;

    public Map<Integer, Recipe> serviceRecipe = new TreeMap<>();
    public Map<Integer, Ingredients> serviceIngredient = new TreeMap<>();

@Override
    public void addRecipe(Recipe recipe) {
       serviceRecipe.put(lastIdRecipe++,recipe);
    }

    @Override
    public void addIngredients(Ingredients ingredients) {
        serviceIngredient.put(lastIdIngrediens++, ingredients);
    }

    @Override
    public void getRecipe(Recipe recipe) {
        serviceRecipe.get(recipe);
    }

    @Override
    public  void getIngredients(Ingredients ingredients){
            serviceIngredient.get(ingredients);
    }

}

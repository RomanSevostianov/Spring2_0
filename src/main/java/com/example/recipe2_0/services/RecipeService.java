package com.example.recipe2_0.services;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.model.Recipe;

public interface RecipeService {


    void addIngredients (Ingredients ingredients);


    void getRecipe(Recipe recipe);

    void getIngredients(Ingredients ingredients);


    void addRecipe(Recipe recipe);
}

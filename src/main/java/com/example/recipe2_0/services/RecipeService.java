package com.example.recipe2_0.services;

import com.example.recipe2_0.model.Recipe;

public interface RecipeService {

    Recipe getRecipe(long id);

    long postRecipe(Recipe recipe);

    Recipe putRecipe(long id, Recipe recipe);

    Recipe deleteRecipe(long id);
}

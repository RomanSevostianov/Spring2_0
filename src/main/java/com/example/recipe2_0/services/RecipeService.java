package com.example.recipe2_0.services;
import com.example.recipe2_0.model.Recipe;

public interface RecipeService {

    Recipe getRecipe(int number);

    int addRecipe(Recipe recipe);

   Recipe removeRecipe (int number);
}

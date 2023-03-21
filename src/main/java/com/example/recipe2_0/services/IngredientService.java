package com.example.recipe2_0.services;

import com.example.recipe2_0.model.Ingredients;

public interface IngredientService {

    int addIngredients (Ingredients ingredients);

    Ingredients getIngredients(int number);
}

package com.example.recipe2_0.services;

import com.example.recipe2_0.model.Ingredients;

public interface IngredientService {

    Ingredients getIngredients(long id);

    long postIngredients (Ingredients ingredients);

    Ingredients putIngredients(long id, Ingredients ingredients);

    Ingredients deleteIngredients (long id);

}

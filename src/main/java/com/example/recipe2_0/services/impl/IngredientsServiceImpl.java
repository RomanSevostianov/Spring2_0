package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientService {

    private  int counter = 0;
    private final Map<Integer, Ingredients> ingredient = new LinkedHashMap<>();

    @Override
    public int addIngredients(Ingredients ingredients) {
        ingredient.put(counter++, ingredients);
        return counter;
    }

    @Override
    public Ingredients getIngredients(int number) {
        return ingredient.get(number);
    }
}

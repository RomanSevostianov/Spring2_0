package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientService {

    private long counter = 0;
    public Map<Long, Ingredients> ingredient = new LinkedHashMap<>();



    @Override
    public Ingredients getIngredients(long id) {
        return ingredient.get(id);
    }


    @Override
    public long postIngredients(Ingredients ingredients) {
        ingredient.put(counter, ingredients);
        return counter++;
    }

    @Override
    public Ingredients putIngredients(long id, Ingredients ingredients) {
        if (ingredient.containsKey(id)) {
            return ingredient.put(id, ingredients);
        }
        return null;
    }

    @Override
    public Ingredients deleteIngredients(long id) {
        if (ingredient.containsKey(id)) {
           return ingredient.remove(id);
        }
  return null;
    }


}

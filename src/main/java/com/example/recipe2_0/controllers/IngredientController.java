package com.example.recipe2_0.controllers;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.services.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/addingredient")

    public int addIngredient (@RequestParam Ingredients ingredients){
        return ingredientService.addIngredients(ingredients);
    }

    @GetMapping ("/getIngredients")
    public void getIngredient (@RequestParam int number){
        ingredientService.getIngredients(number);

    }
}

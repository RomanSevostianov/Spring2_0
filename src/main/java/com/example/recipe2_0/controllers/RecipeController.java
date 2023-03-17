package com.example.recipe2_0.controllers;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cooking")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/addNewRecipe")
    public void addRecipes(@RequestParam  Recipe recipe) {
        this.recipeService.addRecipe(recipe);
    }

}

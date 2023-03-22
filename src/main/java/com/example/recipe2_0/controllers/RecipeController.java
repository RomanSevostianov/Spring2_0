package com.example.recipe2_0.controllers;

import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cooking")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/addNewRecipe")
    public int addRecipes(@RequestParam  Recipe recipe) {
       return recipeService.addRecipe(recipe);
    }

    @GetMapping ("/getRecipe")
    public void getRecipe (@RequestParam int number){
       recipeService.getRecipe(number);
    }

}

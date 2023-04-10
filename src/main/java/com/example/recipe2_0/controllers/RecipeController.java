package com.example.recipe2_0.controllers;

import com.example.recipe2_0.model.Recipe;
import com.example.recipe2_0.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cooking")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Получение рецепты",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        if (id != null) {
            recipeService.getRecipe(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/post")
    @Operation(
            summary = "Создание и добавление рецепта",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Long> postRecipe(@RequestBody Recipe recipe) {
        long id = recipeService.postRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/put/{id}")
    @Operation(
            summary = "Редактирование данных и выполнение действий над ними",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Recipe> putRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe recipes = recipeService.putRecipe(id, recipe);
        if (recipes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);

    }
    @DeleteMapping("del/{id}")
    @Operation(
            summary = "Удаление данных",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        Recipe recipes = recipeService.deleteRecipe(id);
        if (recipes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}

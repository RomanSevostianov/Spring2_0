package com.example.recipe2_0.controllers;

import com.example.recipe2_0.model.Ingredients;
import com.example.recipe2_0.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты", description = "Продукты которые входят в рецепт")

public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping("/get/{id}")
    @Operation(
            summary = "Получение ингредиента по номеру",
            description = "Введите номер ингредиента"
    )
@Parameters (value = {

        @Parameter (name = "id",example = "1")
})
    @ApiResponses(value = {
            @ApiResponse (
                    responseCode = "200",
                    description = "Ингредиенты были найдены"

            )
    }
    )
    public Ingredients getIngredients(@PathVariable Long id) {
        if (id != null) {
            return ingredientService.getIngredients(id);
        }
        return null;

    }

    @PostMapping("/post")
    @Operation(
            summary = "Создание и добовление новых данных",
            description = "Введите номер ингредиента"
    )
    @Parameters (value = {

            @Parameter (name = "id",example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse (
                    responseCode = "200",
                    description = "Ингредиенты были найдены"

            )
    }
    )

    public ResponseEntity<Long> postIngredient(@RequestBody Ingredients ingredients) {
        long id = ingredientService.postIngredients(ingredients);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/put/{id}")
    @Operation(
            summary = "Редактирование данных",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Ingredients> putIngredient(@PathVariable Long id, @RequestBody Ingredients ingredients) {
        Ingredients ingredient = ingredientService.putIngredients(id, ingredients);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Удаление ингредиенты",
            description = "Введите номер ингредиента"
    )
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        if (ingredientService.deleteIngredients(id) != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}


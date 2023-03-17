package com.example.recipe2_0.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredients {

    private String nameIngredients;
    private int quantityIngredients; // колличество ингредиентов
    private String unit; //единица измерения

}

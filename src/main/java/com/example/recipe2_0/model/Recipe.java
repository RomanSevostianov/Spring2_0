package com.example.recipe2_0.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {

    private String nameRecipe;
    private int timeCooking;
    private Ingredients ingredients;
    private String comment;

}

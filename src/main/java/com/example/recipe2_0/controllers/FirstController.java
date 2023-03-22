package com.example.recipe2_0.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("*")
    public String firstWorld (){
        return  "Первая работа";
    }

}

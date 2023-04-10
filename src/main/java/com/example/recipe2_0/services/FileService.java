package com.example.recipe2_0.services;

public interface FileService {


    String readFile();

    boolean saveToFile(String json);

    boolean cleanFile();
}

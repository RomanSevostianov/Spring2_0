package com.example.recipe2_0.services.impl;

import com.example.recipe2_0.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {


    @Value("${pathToDateFile}")
    private String pathToDateFile;

    @Value("${nameOfDateFile}")
    private String nameOfDateFile;

    @Override
    public String readFile() {
        try {
            return Files.readString(Path.of(pathToDateFile, nameOfDateFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveToFile(String json) {

        try {
            cleanFile();
            Files.writeString(Path.of(pathToDateFile,nameOfDateFile), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cleanFile() {
        try {
            Path path = Path.of(pathToDateFile,nameOfDateFile);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}

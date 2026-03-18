package com.learning.filenio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletFileNIO {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("datanio.txt");
            Files.delete(path);
            System.out.println("File deleted successfully");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

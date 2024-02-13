package ru.fafurin.lesson7.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    public String getFilenameContent(String filename) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return result;
    }
}

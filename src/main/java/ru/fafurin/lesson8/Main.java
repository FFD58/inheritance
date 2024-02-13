package ru.fafurin.lesson8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Урок 8. finally
public class Main {
    public static void main(String[] args) {

// 1. Пользователь вводит 5 названий файлов. Они могут повторяться.
// Сохраните в каждый из файл названия ВСЕХ 5 файлов, используйте try with resources
        String[] filenames = makeFilesArr(2);
        for (String filename : filenames) {
            try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filename))) {
                bufferWriter.write(Arrays.toString(filenames).replace("[", "").replace("]", ""));
                bufferWriter.write("\n");
                System.out.println(filename + " saved.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

// 2. Пользователь вводит 5 названий файлов. Сохраните в каждый из файл названия ВСЕХ 5 файлов, используйте try.. catch..finally
        filenames = makeFilesArr(2);
        try {
            for (String filename : filenames) {
                BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filename));
                bufferWriter.write(Arrays.toString(filenames).replace("[", "").replace("]", ""));
                bufferWriter.write("\n");
                bufferWriter.close();
                System.out.println(filename + " saved.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program is completed");
        }
    }

    private static String[] makeFilesArr(int count) {
        Scanner scanner = new Scanner(System.in);
        String[] filenames = new String[count];
        for (int x = 0; x < filenames.length; x++) {
            System.out.print("Enter a filename: ");
            filenames[x] = scanner.next();
            try {
                new File(filenames[x]).createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return filenames;
    }
}

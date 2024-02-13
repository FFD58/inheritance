package ru.fafurin.lesson3.task1;

public class Directory {
    String path;

    public Directory() {
        this.path = System.getProperty("user.dir");
    }
}

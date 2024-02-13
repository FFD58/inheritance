package ru.fafurin.lesson3.task1;

public class File extends Directory {
    String filename;

    public File(String filename) {
        super();
        this.filename = filename;
    }

    @Override
    public String toString() {
        return this.path + "\\" + this.filename;
    }
}

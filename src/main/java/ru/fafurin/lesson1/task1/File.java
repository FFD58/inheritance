package ru.fafurin.lesson1.task1;

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

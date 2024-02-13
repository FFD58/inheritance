package ru.fafurin.lesson9.task3.unchecked;

public class FirstUncheckedException extends RuntimeException {
    public FirstUncheckedException() {
        super("This is a first unchecked exception");
    }
}

package ru.fafurin.lesson9.task3.unchecked;

public class SecondUncheckedException extends RuntimeException {
    public SecondUncheckedException() {
        super("This is a second unchecked exception");
    }
}

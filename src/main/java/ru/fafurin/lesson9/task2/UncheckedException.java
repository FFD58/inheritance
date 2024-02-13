package ru.fafurin.lesson9.task2;

public class UncheckedException extends RuntimeException {
    public UncheckedException() {
        super("This is unchecked exception");
    }
}

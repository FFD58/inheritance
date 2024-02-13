package ru.fafurin.lesson6.task2;

public class WrongInputDataException extends RuntimeException {
    public WrongInputDataException() {
        super("Wrong input data!");
    }
}

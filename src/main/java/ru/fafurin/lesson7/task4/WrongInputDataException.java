package ru.fafurin.lesson7.task4;

public class WrongInputDataException extends RuntimeException {
    public WrongInputDataException() {
        super("Wrong input data!");
    }
}

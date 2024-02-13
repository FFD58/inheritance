package ru.fafurin.lesson6.task4;

public class WrongDateException extends RuntimeException {
    public WrongDateException() {
        super("Wrong input date!");
    }
}

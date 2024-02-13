package ru.fafurin.lesson6.task4;

public class WrongStringException extends RuntimeException {
    public WrongStringException() {
        super("Wrong input string!");
    }
}

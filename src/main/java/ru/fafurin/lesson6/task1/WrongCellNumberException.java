package ru.fafurin.lesson6.task1;

public class WrongCellNumberException extends RuntimeException {
    public WrongCellNumberException() {
        super("Wrong cell number entered!");
    }
}

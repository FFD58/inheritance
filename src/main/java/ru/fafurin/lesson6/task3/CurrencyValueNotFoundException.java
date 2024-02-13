package ru.fafurin.lesson6.task3;

public class CurrencyValueNotFoundException extends RuntimeException {
    public CurrencyValueNotFoundException() {
        super("Currency value not found!");
    }
}

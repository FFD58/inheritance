package ru.fafurin.lesson6.task4;

public class CurrencyValueNotFoundException extends RuntimeException {
    public CurrencyValueNotFoundException() {
        super("Currency value not found!");
    }
}

package ru.fafurin.lesson6.task3;

public class NoCurrencyValueForThisDate extends RuntimeException {
    public NoCurrencyValueForThisDate() {
        super("There is no currency exchange rate for this date!");
    }
}

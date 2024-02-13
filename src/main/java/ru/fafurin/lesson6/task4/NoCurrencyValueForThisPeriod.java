package ru.fafurin.lesson6.task4;

public class NoCurrencyValueForThisPeriod extends RuntimeException {
    public NoCurrencyValueForThisPeriod() {
        super("There is no currency exchange rate for this period!");
    }
}

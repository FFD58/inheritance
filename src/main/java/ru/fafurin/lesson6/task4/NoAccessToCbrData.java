package ru.fafurin.lesson6.task4;

public class NoAccessToCbrData extends RuntimeException {
    public NoAccessToCbrData() {
        super("There is no access to the api of the Central Bank of the Russian Federation!");
    }
}

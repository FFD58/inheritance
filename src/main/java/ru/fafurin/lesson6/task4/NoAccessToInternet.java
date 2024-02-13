package ru.fafurin.lesson6.task4;

public class NoAccessToInternet extends RuntimeException {
    public NoAccessToInternet() {
        super("There is no access to the Internet!");
    }
}

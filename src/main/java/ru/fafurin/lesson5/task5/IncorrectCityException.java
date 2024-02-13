package ru.fafurin.lesson5.task5;

public class IncorrectCityException extends Throwable {
    private final String message = "Entered city not found! Please, restart a program.";

    public String getMessage() {
        return this.message;
    }
}

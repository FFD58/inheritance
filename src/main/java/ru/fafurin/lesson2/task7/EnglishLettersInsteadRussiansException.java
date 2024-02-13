package ru.fafurin.lesson2.task7;

public class EnglishLettersInsteadRussiansException extends RuntimeException {

    private final String message = "Entered a english letter instead a russian letter!";

    public String getMessage() {
        return this.message;
    }
}

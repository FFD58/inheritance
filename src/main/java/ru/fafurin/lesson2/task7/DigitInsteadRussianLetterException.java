package ru.fafurin.lesson2.task7;

public class DigitInsteadRussianLetterException extends RuntimeException {

    private final String message = "Entered a digit letter instead a russian letter!";

    public String getMessage() {
        return this.message;
    }
}

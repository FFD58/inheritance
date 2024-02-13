package ru.fafurin.lesson6.task4;

public class WrongPhoneNumberException extends RuntimeException {
    public WrongPhoneNumberException() {
        super("Wrong phone number entered!");
    }
}

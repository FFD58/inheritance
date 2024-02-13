package ru.fafurin.lesson9.task3;

import java.util.Random;

public class ExceptionManager {
    private Exception[] checkedExceptions = new Exception[5];

    private Exception[] exceptions;

    private RuntimeException[] uncheckedExceptions = new RuntimeException[5];

    private Random random = new Random();

    public void setCheckedExceptions(Exception[] checkedExceptions) {
        this.checkedExceptions = checkedExceptions;
    }

    public void setUncheckedExceptions(RuntimeException[] uncheckedExceptions) {
        this.uncheckedExceptions = uncheckedExceptions;
    }

    public Exception getRandomException() {
        this.mergeExceptionsArrays();

        int randomNumber = random.nextInt(this.exceptions.length);
        return this.exceptions[randomNumber];
    }

    private void mergeExceptionsArrays() {
        int newArrLength = this.checkedExceptions.length + this.uncheckedExceptions.length;
        this.exceptions = new Exception[newArrLength];
        int index = exceptions.length / 2;
        for (int x = 0; x < index; x++) {
            exceptions[x] = this.checkedExceptions[x];
            exceptions[x + index] = this.uncheckedExceptions[x];
        }
    }
}

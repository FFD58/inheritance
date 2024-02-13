package ru.fafurin.lesson6.task4;

import java.util.Random;
import java.util.Scanner;

public class ExceptionsArray {
    private final RuntimeException[] exceptions;

    private static final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public ExceptionsArray(RuntimeException[] exceptions) {
        this.exceptions = exceptions;
//        this.printExceptions();
//        this.chooseException();
    }

    public void printExceptions() {
        System.out.println("You can choose one exception by number:");
        for (int x = 0; x < this.exceptions.length; x++) {
            System.out.println(x + 1 + " - " + this.exceptions[x].getMessage());
        }
    }

    public void chooseException() {
        System.out.println("Get you choose...");
        int number = this.scanner.nextInt() - 1;
        if (number < 0 || number > this.exceptions.length) throw new WrongInputDataException();
        System.out.println("An excellent choice!");
        System.out.println("Get it!");
        throw this.exceptions[number];
    }

    public Exception throwRandomException() {
        int randomValue = random.nextInt(10);
        System.out.println("You wanted a random exception?");
        System.out.println("Get it!");
        return exceptions[randomValue];
    }
}

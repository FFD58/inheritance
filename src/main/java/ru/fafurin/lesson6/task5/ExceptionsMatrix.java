package ru.fafurin.lesson6.task5;

import ru.fafurin.four.lesson6.task4.WrongInputDataException;

import java.util.Scanner;

public class ExceptionsMatrix {
    private final RuntimeException[][] exceptionsMatrix;
    private final Scanner scanner = new Scanner(System.in);

    public ExceptionsMatrix(RuntimeException[][] exceptionsMatrix) {
        this.exceptionsMatrix = exceptionsMatrix;
        this.printExceptions();
        this.chooseException();
    }
    public void printExceptions() {
        System.out.println("You can choose one of 9 exceptions by row and col number:");
    }

    public void chooseException() {
        System.out.print("Enter row number: ");
        int row = this.scanner.nextInt() - 1;
        System.out.print("Enter col number: ");
        int col = this.scanner.nextInt() - 1;

        checkInputData(row, col);

        System.out.println("An excellent choice!");
        System.out.println("Get it!");
        throw exceptionsMatrix[row][col];
    }

    private void checkInputData(int row, int col) {
        if (row < 0 && col < 0 || row > 2 && col > 2) throw new WrongInputDataException();
    }
}

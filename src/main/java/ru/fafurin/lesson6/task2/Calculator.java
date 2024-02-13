package ru.fafurin.lesson6.task2;

import java.util.Scanner;

public class Calculator {

    private final Scanner scanner = new Scanner(System.in);

    public Calculator() {
        System.out.println("Welcome to ICalculator v.0.2 \n" +
                "Please, enter the mathematical expression (for example: 5 / 4 * 7): \n" +
                "Each number or operator starts on a new line \n" +
                "Available operators: + - / * ^)");
        this.start();
    }

    private void start() {
        double x = checkInputData();
        char operator1 = operatorCheck();
        double y = checkInputData();
        char operator2 = operatorCheck();
        double z = this.scanner.nextDouble();
        System.out.println("=");
        if (operatorPriority(operator1)) {
            System.out.println(calc(operator2, calc(operator1, x, y), z));
        } else System.out.println(calc(operator1, calc(operator2, y, z), x));
    }

    private double checkInputData() {
        double result;
        try {
            result = this.scanner.nextDouble();
        } catch (RuntimeException e) {
            throw new WrongInputDataException();
        }
        return result;
    }

    // выполняет арифметические операции
    private double calc(char operator, double x, double y) {
        double res = 0;
        switch (operator) {
            case '+' -> res = x + y;
            case '-' -> res = x - y;
            case '/' -> res = x / y;
            case '*' -> res = x * y;
            case '^' -> res = Math.pow(x, y);
        }
        return res;
    }

    // определяет приоритет операторов
    private boolean operatorPriority(char operator) {
        return operator == '/' || operator == '*' || operator == '^';
    }

    // проверяет корректны ли операторы
    private char operatorCheck() {
        char operator = this.scanner.next().charAt(0);
        while (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '^') {
            System.out.print("Enter the correct mathematical action: ");
            operator = this.scanner.next().charAt(0);
        }
        return operator;
    }

}

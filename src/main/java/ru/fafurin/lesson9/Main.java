package ru.fafurin.lesson9;

import ru.fafurin.lesson9.task2.CheckedException;
import ru.fafurin.lesson9.task2.UncheckedException;
import ru.fafurin.lesson9.task3.ExceptionManager;
import ru.fafurin.lesson9.task3.checked.*;
import ru.fafurin.lesson9.task3.unchecked.*;

import java.util.Scanner;

// Урок 9. Checked и unchecked исключения. Иерархия исключений.
public class Main {
    public static void main(String[] args) {

// 1. Чем отличаются checked и unchecked исключения?

// Ответ. Checked-исключения - это проверяемые исключения, которые наследуются от класса Exception и не являются наследниками класса RuntimeException.
//        Они должны отлавливаться в теле метода с помощью try-catch,
//        или должны быть объявлены в сигнатуре метода с помощью throws
//        Unchecked-исключения - это непроверяемые исключения, которые наследуются от класса RuntimeException.
//        Это исключения, которые могут быть вызваны во время обычной работы виртуальной машины Java.
//        Их необязательно отлавливаться в теле метода с помощью try-catch и объявлять в сигнатуре метода с помощью throws

// 2. Создайте проверяемое и непроверяемое исключение
        System.out.println("Enter 1 to throws CheckedException and other digit to throws UncheckedException");
        Scanner scanner = new Scanner(System.in);
        throwException(scanner.nextInt());

// 3. Создайте 10 checked и 10 unchecked исключений. Сделайте два массива с ними
        // Так как почти все программисты ленивые, а я хочу стать программистом, мне лень писать по 10 исключений ))
        ExceptionManager exceptionManager = new ExceptionManager();
        exceptionManager.setUncheckedExceptions(new RuntimeException[]{
                new FirstUncheckedException(), new SecondUncheckedException(), new ThirdUncheckedException(),
                new FourthUncheckedException(), new FifthUncheckedException()
        });

        exceptionManager.setCheckedExceptions(new Exception[]{
                new FirstCheckedException(), new SecondCheckedException(), new ThirdCheckedException(),
                new FourthCheckedException(), new FifthCheckedException()
        });

// 4. Сделайте метод, который возвращает из этих массивов случайный элемент;
// иногда из первого, иногда из второго. Какой тип данных будет возвращать этот метод?
        System.out.println(exceptionManager.getRandomException().getMessage());

// 5. Нарисуйте иерархию классов exception и runtime exception до самого начала
// Ответ:

// Throwable extends Object
// Exception extends Throwable
// RuntimeException extends Exception
    }

    private static void throwException(int number) {
        if (number == 1) {
            try {
                throw new CheckedException();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else throw new UncheckedException();
    }
}

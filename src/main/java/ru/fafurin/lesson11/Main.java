package ru.fafurin.lesson11;

import java.util.Arrays;

// Урок 11. Stacktrace, call trace
public class Main {
    public static void main(String[] args) {
// 1. Что такое stacktrace?
// Ответ: stacktrace - это цепочка вызовов методов.

// 2. Выведите stacktrace
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.println(Arrays.toString(elements));

// 3. Какой самый простой способ проследить цепочку вызовов конкретного метода?
// Ответ: Дебаг - отличный способ проследить цепочку вызовов конкретного метода!

// 4. А второй способ?
// Ответ: с помощью вывода stacktrace из пункта 2
    }
}

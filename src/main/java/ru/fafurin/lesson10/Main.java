package ru.fafurin.lesson10;

import ru.fafurin.lesson7.PageDownloader;

import java.util.Arrays;

// Урок 10. Ключевое слово null, NullPointerException
public class Main {
    public static void main(String[] args) {
// 1. Выбросите NPE
        ExampleDefaultValues exampleDefaultValues = new ExampleDefaultValues();
        getLoader(exampleDefaultValues.pageDownloader);

// 2. Напишите код, в котором будет выброшен нпе, при этом не используется throw
        exampleDefaultValues.pageDownloader.downloadWebPage("yandex.ru");

// 3. Как уберечься от
// Задание не дописано. Могу предположить, что вопрос был: как уберечься от NPE

// Ответ: проверять объекты на null, как в методе на строке 38, например

// 4. Что такое null?
// Ответ: null - это значение по-умолчанию для любого объекта

// 5. Создайте массив nullов
        ExampleDefaultValues[] exampleValues = new ExampleDefaultValues[5];
        System.out.println(Arrays.toString(exampleValues));

// 6. Выведите сумму nullов
// Мы получим NullPointerException
        int sum = 0;
        for (int x = 0; x < exampleValues.length; x++) {
            sum += exampleValues[x].x;
        }
        System.out.println(sum);
    }

    private static PageDownloader getLoader(PageDownloader pageDownloader) {
        if (pageDownloader == null) throw new NullPointerException();
        else return pageDownloader;
    }
}

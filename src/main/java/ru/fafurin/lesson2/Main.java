package ru.fafurin.lesson2;

import ru.fafurin.lesson2.task3.Company;
import ru.fafurin.lesson2.task3.OS;
import ru.fafurin.lesson2.task4.WebSite;
import ru.fafurin.lesson2.task6.Currency;
import ru.fafurin.lesson2.task6.CurrencyLoader;
import ru.fafurin.lesson2.task7.TextChecker;
import ru.fafurin.lesson2.task8.KeyboardSwitch;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// Урок 2. Конструкторы
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        // 1. Что такое конструктор по-умолчанию?

        // Ответ: Конструктор по-умолчанию - это конструктор, который создается компилятором,
        // если в классе не определены никакие конструкторы.

        // 2. Как сделать так, чтобы при каждом создании экземпляра класса, в консоль что-то выводилось? (Слежка за классом :) )

        // Ответ: нужно прописать вызов в консоль в конструктор класса. При инициализации нового объекта этого класса, сработает вызов в консоль

        // 3. Сделайте класс, отображающий операционную систему; сделайте конструктор для него. Создайте несколько экземпляров
        OS windows = new OS("Windows 10", new Company("Microsoft", "IT", "last century", 153), "10.01.2010", "10");
        OS macOs = new OS("MacOS", new Company("Apple", "IT", "last century", 3), "10.01.2012", "0.5");

        // 4. Сделайте класс WebSite, и несколько конструкторов для него; продемонстрируйте использование
        WebSite webSite = new WebSite();
        WebSite webSite1 = new WebSite("https://lms.synergy.ru/student/updiscipline/5677705/1416845/1/1");
        WebSite webSite2 = new WebSite(new File[5]);
        WebSite webSite3 = new WebSite("https://lms.synergy.ru/student/updiscipline/5677705/1416845/1/1", new File[5]);

        // 5. Создайте экземпляры StringBuilder, используя несколько конструкторов
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder(5);
        StringBuilder builder2 = new StringBuilder("String");

        // 6. Сделайте класс Url(ссылка) с несколькими конструкторами;
        // сделайте класс CurrencyCourse (курс валют) с несколькими конструкторами;
        // внутри конструктора CurrencyCourse вызывайте также конструктор Url - инициализируйте ссылку,
        // по которой будете получать курс валют; запросите курс валют.
        URL url = new URL("https://lms.synergy.ru/");
        URL url1 = new URL(url, "https://lms.synergy.ru/");
        CurrencyLoader loader = new CurrencyLoader("10/02/2020", Currency.USD);
        loader.writeCurrencyQuotesByDateToFile();

        // 7. Создайте класс TextChecker. Его конструктор принимает строку и внутри него будет происходить:
        // Проверка текста на наличие иностранных букв вместо русской раскладки и цифр вместо нуля и буквы «з».
        // Если обнаружена такая подмена - выбрасывается исключение
        TextChecker checker = new TextChecker("0колица");

        // 8. Создайте класс KeyboardSwitch. Его конструктор принимает строку и внутри него происходит:
        // Перевод текста в нужный язык(забыл переключить клавиатуру и напечатал другим языком).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        KeyboardSwitch keyboardSwitch = new KeyboardSwitch(scanner.nextLine());
    }
}

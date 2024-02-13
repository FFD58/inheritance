package ru.fafurin.lesson7;

import ru.fafurin.lesson7.task4.Calculator;
import ru.fafurin.lesson7.task5.HtmlSaver;
import ru.fafurin.lesson7.task6.MyFileReader;
import ru.fafurin.lesson7.task7.LoaderFromNasaApi;

import java.util.InputMismatchException;
import java.util.Scanner;

// Урок 7. Обработка исключений, try.. catch
public class Main {
    public static void main(String[] args) {

// 1. В чем разница между throw и throws в Java?

// Ответ. Оператор throw вызывается внутри метода для выбрасывания исключения
// Оператор throws указывается в сигнатуре метода для указания на выбрасываемые этим методом исключения

// 2. Пользователь вводит число. Если произошла ошибка ввода,
// выведите пользователю сообщение о том, что ввод некорректный
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            System.out.println(number);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input data!");
        }
// 3. Пользователь вводит число. Если произошла ошибка ввода,
// дайте пользователю ввести еще раз: так пока он не введёт нормально (подсказка: while)
        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.next();
            try {
                System.out.println(Integer.parseInt(input));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Your 'number' is not a number! Try again...");
            }
        }

// 4. Доработайте калькулятор. Если пользователь ввел неверное значение,
// просто дайте ему ввести еще раз. (Пока он не введёт корректно)
        Calculator calculator = new Calculator();

// 5. Пользователь вводит адрес ссылки. Если удаётся скачать страничку по адресу,
// сохранить ее в html файл; иначе вывести, что страница не найдена.
        System.out.print("Enter a url (for example: https://ya.ru/): ");
        PageDownloader pageDownloader = new PageDownloader();
        HtmlSaver htmlSaver = new HtmlSaver();
        htmlSaver.getHtmlFileFromUrl(pageDownloader.downloadWebPage(scanner.nextLine()));

// 6. Пользователь вводит имя файла. Выведите содержимое этого файла,
// если не получилось - выведите сообщение, что файл не найден
        System.out.print("Enter a filename: ");
        MyFileReader fileReader = new MyFileReader();
        System.out.println(fileReader.getFilenameContent(scanner.next()));

// 7. Доработайте скачивальщик снимков NASA, чтобы в нем не было ни одного throws
// (пройдитесь прям поиском по файлу). Throws придётся заменить на try catch.
        LoaderFromNasaApi loader = new LoaderFromNasaApi();
        System.out.println(loader.returnTodayExplanation());
    }
}

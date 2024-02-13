package ru.fafurin.lesson6;

import ru.fafurin.lesson6.task1.TicTacToeGame;
import ru.fafurin.lesson6.task2.Calculator;
import ru.fafurin.lesson6.task3.Currency;
import ru.fafurin.lesson6.task3.CurrencyLoader;
import ru.fafurin.lesson6.task3.DatePeriod;
import ru.fafurin.lesson6.task4.*;
import ru.fafurin.lesson6.task5.ExceptionsMatrix;

import java.time.LocalDate;

// Урок 6. Создание исключений, throw
public class Main {
    public static void main(String[] args) throws Exception {
// 1. Доработайте крестики-нолики; создайте исключение, которое будете бросать при неверном вводе пользователя
        TicTacToeGame game = new TicTacToeGame(3, 3);
        game.startGame();

// 2. Доработайте калькулятор: при неверном вводе выбрасывайте исключение
        Calculator calculator = new Calculator();

// 3. Аналогичным образом, доработайте запрос курса валют на дату: при некорректном вводе бросайте исключение.
// При отсутствии курса валют в ответе, бросайте другое исключение .
        DatePeriod datePeriod = new DatePeriod();
        datePeriod
                .setStartDate(LocalDate.of(2024, 11, 1))
                .setEndDate(LocalDate.of(2024, 11, 5));

        CurrencyLoader loader = new CurrencyLoader();
        loader.getCurrencyValuesFromDatePeriod(datePeriod, Currency.EUR);

// 4. Создайте 10 классов-исключений. Соберите их в массив. Пусть пользователь выбирает, какое по счету исключение выбросить.
        RuntimeException[] exceptions = new RuntimeException[]{
                new CurrencyValueNotFoundException(),
                new NoAccessToCbrData(),
                new NoAccessToInternet(),
                new WrongPhoneNumberException(),
                new WrongStringException(),
                new WrongDateException(),
                new NoCurrencyValueForThisDate(),
                new NoCurrencyValueForThisPeriod(),
                new WrongCellNumberException(),
                new WrongInputDataException()
        };
        ExceptionsArray exceptionsArray = new ExceptionsArray(exceptions);


// 5. Соберите их в матрицу 3х3. Пусть пользователь выбирает номер столбца и строки, какое выбросить исключение. Если ввод неверный - выбросите десятое.
        RuntimeException[][] exceptionsMatrix = new RuntimeException[][]{
                {new CurrencyValueNotFoundException(), new NoAccessToCbrData(), new NoAccessToInternet()},
                {new WrongPhoneNumberException(), new WrongStringException(), new WrongDateException()},
                {new NoCurrencyValueForThisDate(), new NoCurrencyValueForThisPeriod(), new WrongCellNumberException()}
        };
        ExceptionsMatrix exceptionsMatrix1 = new ExceptionsMatrix(exceptionsMatrix);

// 6. Сделайте функцию, которая возвращает случайное исключение
// из этих 10 (тип возвращаемого значения будет общий: Exception). Выбросите это случайное исключение
        throw exceptionsArray.throwRandomException();
    }
}

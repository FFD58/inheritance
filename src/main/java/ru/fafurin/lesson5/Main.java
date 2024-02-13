package ru.fafurin.lesson5;

import ru.fafurin.lesson5.task2.MyCalendar;
import ru.fafurin.lesson5.task5.FlightCalculator;
import ru.fafurin.lesson5.task6.Currency;
import ru.fafurin.lesson5.task6.CurrencyLoader;
import ru.fafurin.lesson5.task6.DatePeriod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Урок 5. Работа с датами.
public class Main {
    public static void main(String[] args) {

// 1. Выведите все даты текущего года
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 1);
        while (startDate.isBefore(endDate)) {
            System.out.println(startDate);
            startDate = startDate.plusDays(1);
        }

// 2. “Нарисуйте” календарь: январь пн вт ср чт пт сб вс 1 2 3 4 5 6 … и так далее
        MyCalendar myCalendar = new MyCalendar(LocalDate.of(2024, 1, 1), 24);


        // 3. В 12 часов 1 января 2020 года вы вылетаете из Москвы во Владивосток,
// длительность полета составляет 10 часов 15 минут.
// Вопрос в том, во сколько вы приедете во Владивосток? Используйте ZonedDateTime

        LocalDateTime departureDateTime = LocalDateTime.of(2020,1,1, 12,0);

        ZoneId zoneIdMoscow = ZoneId.of("Europe/Moscow");
        ZoneId zoneIdVladivostok = ZoneId.of("Asia/Vladivostok");

        ZonedDateTime departureDateTimeMoscow = ZonedDateTime.of(departureDateTime, zoneIdMoscow);
        ZonedDateTime departureDateTimeVladivostok = departureDateTimeMoscow.withZoneSameInstant(zoneIdVladivostok);

        ZonedDateTime arrivalDateTime = departureDateTimeVladivostok.plusHours(10).plusMinutes(15);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        System.out.println("Departure time and date from Moscow according to Vladivostok time: " + departureDateTimeVladivostok.format(formatter));
        System.out.println("Arrival time and date to Vladivostok according to Vladivostok time: " + arrivalDateTime.format(formatter));


// 4. Пользователь вводит дату, вывести все числа с 1 января того же года до этой даты
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.print("Enter a month: ");
        int month = scanner.nextInt();
        System.out.print("Enter a day: ");
        int day = scanner.nextInt();

        LocalDate end = LocalDate.of(year, month, day + 1);
        LocalDate start = LocalDate.of(year, 1, 1);

        while (start.isBefore(end)) {
            System.out.println(start);
            start = start.plusDays(1);
        }

// 5. Калькулятор полетов. Пользователь вводит, из какого часового пояса он вылетает
// (в формате Europe/Moscow, Asia/Vladivostok и так далее.. можно нагуглить для каждого города),
// во сколько, сколько будет лететь. Напишите местное время прилета
        FlightCalculator calculator = new FlightCalculator();

// 6. Реализуйте класс DatePeriod, в котором будет две LocalDate.
// Переделайте анализатор курса валют, что б он на вход принимал DatePeriod
        DatePeriod datePeriod = new DatePeriod();
        datePeriod
                .setStartDate(LocalDate.of(2022,10,1))
                .setEndDate(LocalDate.of(2022,10,30));

        CurrencyLoader loader = new CurrencyLoader();
        loader.getCurrencyValuesFromDatePeriod(datePeriod, Currency.EUR);
    }
}

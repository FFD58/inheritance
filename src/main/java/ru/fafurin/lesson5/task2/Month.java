package ru.fafurin.lesson5.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Month {
    int[] month;

    private LocalDate startDate;

    private final LocalDate endDate;

    private static int lastMonthDayIndex;

    public Month(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        printMonthTitle();
        printDaysOfWeek();
        fillMonth();
    }

    public static void setLastMonthDayIndex(int lastMonthDayIndex) {
        Month.lastMonthDayIndex = lastMonthDayIndex;
    }

    private void fillMonth() {
        int lastMonthDay = Integer.parseInt(this.returnLastMonthDay(this.startDate));
        this.month = new int[lastMonthDay];
        while (this.startDate.isBefore(this.endDate)) {
            for (int x = 0; x < lastMonthDay; x++) {
                String day = DateTimeFormatter.ofPattern("d").localizedBy(Locale.forLanguageTag("ru")).format(startDate);
                this.month[x] = Integer.parseInt(day);
                if (day.equals(String.valueOf(lastMonthDay))) {
                    printMonth(Month.lastMonthDayIndex);
                    Month.lastMonthDayIndex = Month.returnDayNumberInWeek(startDate);
                    startDate = endDate;
                    break;
                }
                this.startDate = this.startDate.plusDays(1);
            }
        }
    }

    public static int returnDayNumberInWeek(LocalDate date) {
        int result = 0;
        switch (date.getDayOfWeek().toString()) {
            case "MONDAY" -> result = 1;
            case "TUESDAY" -> result = 2;
            case "WEDNESDAY" -> result = 3;
            case "THURSDAY" -> result = 4;
            case "FRIDAY" -> result = 5;
            case "SATURDAY" -> result = 6;
            case "SUNDAY" -> result = 0;
        }
        return result;
    }

    private String returnLastMonthDay(LocalDate date) {
        date = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return formatter.format(date);
    }

    private void printMonthTitle() {
        String month = DateTimeFormatter.ofPattern("MMMM").localizedBy(Locale.forLanguageTag("en")).format(this.startDate);
        if (month.equals("January")) {
            System.out.println();
            this.printYear();
        }
        System.out.println(month);
    }

    private void printYear() {
        System.out.println(DateTimeFormatter.ofPattern("yyyy").localizedBy(Locale.forLanguageTag("en")).format(this.startDate));
    }

    private void printDaysOfWeek() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        for (int x = 0; x < 7; x++) {
            System.out.print(DateTimeFormatter.ofPattern("E").localizedBy(Locale.forLanguageTag("en")).format(date) + " ");
            date = date.plusDays(1);
        }
        System.out.println();
    }

    private void printMonth(int lastMonthDayIndex) {
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < lastMonthDayIndex; y++) {
            builder.append("    ");
        }
        System.out.print(builder);

        for (int x = 0; x < this.month.length; x++) {
            if (this.month[x] < 10) {
                System.out.print(" ");
            }
            System.out.print(this.month[x] + "  ");
            if (this.month[x] == (7 * count - lastMonthDayIndex)) {
                count++;
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("---------------");
    }
}



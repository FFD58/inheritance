package ru.fafurin.lesson5.task2;

import java.time.LocalDate;

public class MyCalendar {

    private final int monthCount;
    private final Month[] calendar;

    private Month month;

    private LocalDate startDate;

    private LocalDate endDate;

    public MyCalendar(LocalDate startDate, int monthCount) {
        this.monthCount = monthCount;
        this.calendar = new Month[monthCount];
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(1);
        this.setLastMonthDayIndex();
        this.fillCalendar();
    }

    private void fillCalendar() {
        for (int x = 0; x < this.calendar.length; x++) {
            this.month = new Month(this.startDate, this.endDate);
            this.startDate = this.startDate.plusMonths(1);
            this.endDate = this.endDate.plusMonths(1);
        }
    }

    // Get digit of week day of last day before start day,
    // and set this digit to Month.
    private void setLastMonthDayIndex() {
        LocalDate lastDayInLastYear = this.startDate.minusDays(1);
        int numberOfWeekDay = Month.returnDayNumberInWeek(lastDayInLastYear);
        Month.setLastMonthDayIndex(numberOfWeekDay);
    }

}
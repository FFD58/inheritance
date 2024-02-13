package ru.fafurin.lesson5.task6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePeriod {

    private LocalDate startDate;

    private LocalDate endDate;

    private final String pattern = "dd/MM/yyyy";

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.pattern);

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public DatePeriod setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public DatePeriod setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public String localDateToString(LocalDate date) {
        return formatter.format(date);
    }

}

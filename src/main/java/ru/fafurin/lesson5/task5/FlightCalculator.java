package ru.fafurin.lesson5.task5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FlightCalculator {
    private String departureDateTime;
    private String flightTime;
    private int flightTimeHours;
    private int flightTimeMinutes;
    private String departureCity;
    private String destinationCity;
    private final Scanner scanner = new Scanner(System.in);
    private final String pattern = "HH:mm dd.MM.yyyy";
    private final String message = "This city will be added to the database soon but for now... Enter a departure city from the list above: ";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.pattern);

    public FlightCalculator() {
        System.out.println("Welcome to close betta-testing of the Flight Calculator v.0.1");
        System.out.println(TimeZone.getAvailableCitiesList());

        this.setData();
        this.timeStringToLocalTime();
        this.printLocalArrivalTime();
    }

    // Getting input data from user
    private void setData() {
        try {
            System.out.print("Enter a departure city: ");
            this.departureCity = checkingCity(this.scanner.nextLine(), this.message);

            System.out.print("Enter a destination city: ");
            this.destinationCity = checkingCity(this.scanner.nextLine(), this.message);

        } catch (IncorrectCityException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.print("Enter a departure time and date (for example 20:00 14.02.2024): ");
        this.departureDateTime = this.scanner.nextLine();

        System.out.print("Enter a flight time (for example 6:12): ");
        this.flightTime = this.scanner.nextLine();
    }

    // Main method to calculate arrival date and time
    private void printLocalArrivalTime() {
        LocalDateTime departureDateTime = this.dateTimeStringToLocalDateTime(this.departureDateTime);
        ZoneId departureCityZoneId = ZoneId.of(TimeZone.getZoneId(this.departureCity));
        ZoneId destinationCityZoneId = ZoneId.of(TimeZone.getZoneId(this.destinationCity));

        ZonedDateTime departureDateTimeDepartureCity = ZonedDateTime.of(departureDateTime, departureCityZoneId);
        ZonedDateTime departureDateTimeDestinationCity = departureDateTimeDepartureCity.withZoneSameInstant(destinationCityZoneId);

        ZonedDateTime arrivalDateTime = departureDateTimeDestinationCity.plusHours(this.flightTimeHours).plusMinutes(this.flightTimeMinutes);

        System.out.printf("Departure time and date according to %s time: %s\n", this.destinationCity, departureDateTimeDestinationCity.format(this.formatter));
        System.out.printf("Arrival time and date according to %s time: %s\n", this.destinationCity, arrivalDateTime.format(this.formatter));
    }

    // Parsing string date time to LocalDateTime object
    public LocalDateTime dateTimeStringToLocalDateTime(String dateTime) {
        try {
            this.formatter.parse(dateTime);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date and time format");
            System.exit(1);
        }
        return LocalDateTime.parse(dateTime, this.formatter);
    }

    // Getting int numbers of month and day from string
    public void timeStringToLocalTime() {
        try {
            this.flightTimeHours = Integer.parseInt(flightTime.substring(0, flightTime.indexOf(':')));
            this.flightTimeMinutes = Integer.parseInt(flightTime.substring(flightTime.indexOf(':') + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Incorrect flight time");
        }
    }

    // Checking entered city for the equals to cities in the TimeZone list
    private String checkingCity(String city, String message) throws IncorrectCityException {
        if (!TimeZone.isCorrectCity(city)) {
            System.out.println(message);
            String cityStr = this.scanner.nextLine();
            if (!TimeZone.isCorrectCity(cityStr)) {
                throw new IncorrectCityException();
            } else return cityStr;
        }
        return city;
    }
}

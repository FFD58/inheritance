package ru.fafurin.lesson5.task5;

public enum TimeZone {
    Kaliningrad("Europe/Kaliningrad", "Калининград", "Kaliningrad"),
    Volgograd("Europe/Volgograd", "Волгоград", "Volgograd"),
    Minsk("Europe/Minsk", "Минск", "Minsk"),
    Kirov("Europe/Kirov", "Киров", "Kirov"),
    Moscow("Europe/Moscow", "Москва", "Moscow"),
    Samara("Europe/Samara", "Самара", "Samara"),
    Yekaterinburg("Asia/Yekaterinburg", "Екатеринбург", "Yekaterinburg"),
    Omsk("Asia/Omsk", "Омск", "Omsk"),
    Krasnoyarsk("Asia/Krasnoyarsk", "Красноярск", "Krasnoyarsk"),
    Irkutsk("Asia/Irkutsk", "Иркутск", "Irkutsk"),
    Yakutsk("Asia/Yakutsk", "Якутск", "Yakutsk"),
    Vladivostok("Asia/Vladivostok", "Владивосток", "Vladivostok"),
    Magadan("Asia/Magadan", "Магадан", "Magadan");

    private final String timeZone;

    private final String cityRus;

    private final String cityEng;

    TimeZone(String timeZone, String cityRus, String cityEng) {
        this.timeZone = timeZone;
        this.cityRus = cityRus;
        this.cityEng = cityEng;
    }

    public String getCityRus() {
        return cityRus;
    }

    public String getCityEng() {
        return cityEng;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public static String getZoneId(String city) {
        String result = "";
        for (TimeZone timeZone : TimeZone.values()) {
            if (city.equals(timeZone.getCityEng())) {
                result = timeZone.getTimeZone();
            }
        }
        return result;
    }

    public static boolean isCorrectCity(String city) {
        boolean result = false;
        for (TimeZone timeZone : TimeZone.values()) {
            if (city.equals(timeZone.getCityEng())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static String getAvailableCitiesList() {
        StringBuilder builder = new StringBuilder();
        builder.append("You can select cities from the list...\n");
        for (TimeZone timeZone : TimeZone.values()) {
            builder.append(timeZone.getCityEng());
            builder.append("\n");
        }
        return builder.toString();
    }

}


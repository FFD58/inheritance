package ru.fafurin.lesson2.task3;

public class OS {
    String title;
    Company company;
    String releaseDate;
    String version;
    public OS(String title, Company company, String releaseDate, String version) {
        this.title = title;
        this.company = company;
        this.releaseDate = releaseDate;
        this.version = version;
    }
    @Override
    public String toString() {
        return "OS{" +
                "title='" + title + '\'' +
                ", company=" + company +
                ", releaseDate='" + releaseDate + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

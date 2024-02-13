package ru.fafurin.lesson3.task2;

public class Moderator extends User {

    public Moderator(String name, String password) {
        super(name, password, "moderator");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role;
    }
}

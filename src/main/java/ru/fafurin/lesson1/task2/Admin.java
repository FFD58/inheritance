package ru.fafurin.lesson1.task2;

public class Admin extends User {


    public Admin(String name, String password) {
        super(name, password, "admin");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role;
    }
}

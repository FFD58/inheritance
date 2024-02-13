package ru.fafurin.lesson4;

public class User {
    public String name;
    public String password;
    public String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public void printName() {
        System.out.println(this.name);
    }
}

package ru.fafurin.lesson4;

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

    public static User returnParent(String name, String password, String role) {
        return new User(name, password, role);
    }

}

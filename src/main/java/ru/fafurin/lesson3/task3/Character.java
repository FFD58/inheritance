package ru.fafurin.lesson3.task3;

public class Character {
    String name;

    public Character(String name) {
        this.name = name;
    }

    public void getAction() {
        System.out.println(this.name + " do something.");
    }
}

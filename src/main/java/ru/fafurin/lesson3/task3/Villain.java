package ru.fafurin.lesson3.task3;

public class Villain extends Character {

    public Villain(String name) {
        super(name);
    }

    @Override
    public void getAction() {
        System.out.println(this.name + " puts his villainous plan into action!");
    }
}

package ru.fafurin.lesson3.task3;

public class Hero extends Character {

    public Hero(String name) {
        super(name);
    }

    @Override
    public void getAction() {
        System.out.println(this.name + " prevents the villain from putting his villainous plan into action!");
    }
}

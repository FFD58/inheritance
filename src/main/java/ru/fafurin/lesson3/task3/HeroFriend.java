package ru.fafurin.lesson3.task3;

public class HeroFriend extends Character {

    public HeroFriend(String name) {
        super(name);
    }

    @Override
    public void getAction() {
        System.out.println(this.name + " helps the hero to prevent the villain from putting his villainous plan into action!");
    }
}

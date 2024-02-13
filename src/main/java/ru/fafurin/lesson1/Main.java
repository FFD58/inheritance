package ru.fafurin.lesson1;

import ru.fafurin.lesson1.task1.File;
import ru.fafurin.lesson1.task2.Admin;
import ru.fafurin.lesson1.task2.Moderator;
import ru.fafurin.lesson1.task2.User;
import ru.fafurin.lesson1.task3.Character;
import ru.fafurin.lesson1.task3.Hero;
import ru.fafurin.lesson1.task3.HeroFriend;
import ru.fafurin.lesson1.task3.Villain;

// Урок 1. Наследование
public class Main {
    public static void main(String[] args) {
        // 1. Реализуйте классы с наследованием: директория, файл

        File file = new File("file.txt");
        System.out.println(file);

        // 2. Реализуйте классы с наследованием: пользователь, администратор, модератор
        User admin = new Admin("Admin", "qwerty");
        User moderator = new Moderator("Moderator", "zxc");
        System.out.println(admin);
        System.out.println(moderator);

        // 3. Реализуйте классы с наследованием: персонаж, главный герой, злодей, друг главного героя
        Character npc = new Character("The actor of the extras");
        Character villain = new Villain("Villain");
        Character hero = new Hero("Hero");
        Character heroFriend = new HeroFriend("Hero Friend");

        npc.getAction();
        villain.getAction();
        hero.getAction();
        heroFriend.getAction();
    }
}

package ru.fafurin.lesson4;

// Урок 4. Преобразование наследников к родителю.
public class Main {
    public static void main(String[] args) {
// 1. Почему наследник всегда можно преобразовать к родителю?
        // Ответ: потому что у наследника есть все поля и методы родительского класса.

// 2. Реализуйте метод, который выводит имя пользователя. Передайте в этот метод также и модератора, и админа
        User user = new User("user", "very_complex_password", "user");
        user.printName();
        Admin admin = new Admin("admin", "very_complex_admin_password");
        admin.printName();
        Moderator moderator = new Moderator("moderator", "very_complex_moderator_password");
        moderator.printName();

// 3. Возможно ли преобразовать родителя к наследнику? Попробуйте
        // Ответ: нет. RunTime выбросит исключение ClassCastException
        Moderator moderator1 = (Moderator) user;
        Admin admin1 = (Admin) user;

// 4. Реализуйте метод, который возвращает родителя, а не наследника. Какой в этом смысл?
        User user1 = Admin.returnParent("new user", "new_very_complex_password", "user");
        user1.printName();
    }
}

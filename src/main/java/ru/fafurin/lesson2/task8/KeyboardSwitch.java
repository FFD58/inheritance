package ru.fafurin.lesson2.task8;

public class KeyboardSwitch {
    private final String str;

    private StringBuilder builder = new StringBuilder();
    private final char[] russianLetters =
            {'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ',
                    'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э', 'я',
                    'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', '.', ' '};

    private final char[] englishLetters =
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']',
                    'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '"', 'z',
                    'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/', ' '};

    public KeyboardSwitch(String str) {
        this.str = str.toLowerCase();
        switchString();
        System.out.println(this.builder);
    }

    private void switchString() {
        if (this.str.matches(".*\\p{InCyrillic}.*")) appendEnglishLetters();
        else appendRussianLetters();
    }

    private void appendEnglishLetters() {
        for (int x = 0; x < this.str.length(); x++) {
            for (int i = 0; i < russianLetters.length; i++) {
                if (this.str.charAt(x) == russianLetters[i]) {
                    this.builder.append(englishLetters[i]);
                }
            }
        }
    }

    private void appendRussianLetters() {
        for (int x = 0; x < this.str.length(); x++) {
            for (int i = 0; i < englishLetters.length; i++) {
                if (this.str.charAt(x) == englishLetters[i]) {
                    this.builder.append(russianLetters[i]);
                }
            }
        }
    }
}

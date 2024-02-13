package ru.fafurin.lesson2.task7;

public class TextChecker {

    private final String str;

    public TextChecker(String str) {
        this.str = str.toLowerCase();
        try {
            this.check();
            System.out.println("The checking was successful!");
        } catch (EnglishLettersInsteadRussiansException | DigitInsteadRussianLetterException e) {
            System.out.println(e.getMessage());
        }
    }

    private void check() {
        for (int x = 0; x < this.str.length(); x++) {
            char letter = this.str.charAt(x);
            if (isEnglish(letter)) {
                throw new EnglishLettersInsteadRussiansException();
            } else {
                checkDigitsInStr(x);
            }
        }
    }

    private void checkDigitsInStr(int index) {
        char letter = this.str.charAt(index);

        if (index == 0) {
            if (letter == '0' && this.isNotDigit(this.str.charAt(index + 1))) {
                throw new DigitInsteadRussianLetterException();
            }
            if (letter == '3' && this.isNotDigit(this.str.charAt(index + 1))) {
                throw new DigitInsteadRussianLetterException();
            }
        } else if (index == this.str.length() - 1) {
            if (letter == '0' && this.isNotDigit(this.str.charAt(index - 2))) {
                throw new DigitInsteadRussianLetterException();
            }
            if (letter == '3' && this.isNotDigit(this.str.charAt(index - 2))) {
                throw new DigitInsteadRussianLetterException();
            }
        } else {
            if (letter == '0' && this.isNotDigit(this.str.charAt(index - 1)) &&
                    this.isNotDigit(this.str.charAt(index + 1))) {
                throw new DigitInsteadRussianLetterException();
            }
            if (letter == '3' && this.isNotDigit(this.str.charAt(index - 1)) &&
                    this.isNotDigit(this.str.charAt(index + 1))) {
                throw new DigitInsteadRussianLetterException();
            }
        }
    }

    private boolean isEnglish(char letter) {
        return letter >= 97 && letter < 123;
    }

    private boolean isNotDigit(char letter) {
        return !(letter >= 48 && letter < 58);
    }

}

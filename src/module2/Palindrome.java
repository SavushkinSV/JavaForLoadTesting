package module2;

import java.util.Scanner;

/**
 * На вход программы подаётся строка, в результате должно быть выведено является ли входная строка
 * палиндромом.
 * Пример:
 * А роза упала на лапу Азора
 */

public class Palindrome {
    public static void main(String[] args) {
        String line = getLine();
        if (checkPalindrome(line)) {
            System.out.println("Это палиндром.");
        } else {
            System.out.println("Обычная строка.");
        }
    }

    private static boolean checkPalindrome(String line) {
        line = line.toLowerCase();
        line = line.replaceAll(" ", "");
        String reverse = new StringBuilder(line).reverse().toString();

        return line.equals(reverse);
    }

    private static String getLine() {
        System.out.print("Введите строку для определения палиндрома -> ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        return line;
    }
}

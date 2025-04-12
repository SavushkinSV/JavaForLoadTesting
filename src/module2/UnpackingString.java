package module2;

import java.util.Scanner;

/**
 * Ссылка на задачу <a href="https://acmp.ru/index.asp?main=task&id_task=231">...</a>
 * <p>
 * Будем рассматривать только строчки, состоящие из заглавных английских букв. Например, рассмотрим
 * строку AAAABCCCCCDDDD. Длина этой строки равна 14. Поскольку строка состоит только из английских букв,
 * повторяющиеся символы могут быть удалены и заменены числами, определяющими количество повторений. Таким образом,
 * данная строка может быть представлена как 4AB5C4D. Длина такой строки 7. Описанный метод мы назовем упаковкой строки.
 * <p>
 * Напишите программу, которая берет упакованную строчку и восстанавливает по ней исходную строку.
 * <p>
 * Пример:
 * 22D7AC18FGD
 * DDDDDDDDDDDDDDDDDDDDDDAAAAAAACFFFFFFFFFFFFFFFFFFGD
 */

public class UnpackingString {
    int lengthChar = 1;

    public static void main(String[] args) {
        UnpackingString unpackingString = new UnpackingString();
        String line = unpackingString.inputLine();
        unpackingString.unpacking(line);
    }

    /**
     * Производит распаковку строки, заданную параметром {@code line}
     *
     * @param line строка, которую нужно распаковать
     */
    private void unpacking(String line) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (Character.isDigit(currentChar)) {
                builder.append(currentChar);
                lengthChar++;
            } else {
                if (lengthChar != 1) {
                    lengthChar = Integer.parseInt(builder.toString());
                }
                printChar(currentChar, lengthChar);
                lengthChar = 1;
                builder.delete(0, builder.length());
            }
        }
    }

    /**
     * Возвращает строку, введенную в консоли
     *
     * @return строка, введенная в консоль
     */
    private String inputLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку для распаковки:");
        String line = sc.nextLine();
        sc.close();

        return line;
    }

    /**
     * Выводит символ {@code ch} в количестве {@code lengthChar}
     *
     * @param ch         символ
     * @param lengthChar длина вывода
     */
    private void printChar(char ch, int lengthChar) {
        for (int i = 0; i < lengthChar; i++) {
            System.out.print(ch);
        }
    }
}

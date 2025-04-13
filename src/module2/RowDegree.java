package module2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Ссылка на задачу <a href="https://acmp.ru/index.asp?main=task&id_task=70">...</a>
 * <p>
 * Пусть задана строка s = s1s2...sn. Назовем ее k-ой (k > 0) степенью sk строку
 * sk = s1s2 ... sns1s2 ... sn......s1s2...sn (k раз). Например, третьей степенью строки abc является строка abcabcabc.
 * Корнем k степени из строки s называется такая строка t (если она существует), что tk = s.
 * <p>
 * Ваша задача состоит в том, чтобы написать программу, находящую степень строки или корень из нее.
 * <p>
 * Пример
 * abc
 * 3
 * abcabcabc
 * <p>
 * abcdabcd
 * -2
 * abcd
 */

public class RowDegree {
    public static void main(String[] args) {
        RowDegree rowDegree = new RowDegree();
        String line = rowDegree.inputLine();

        int row;
        try {
            row = rowDegree.inputRow();
            String rowString = rowDegree.row(line, row);
            System.out.println(rowString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Возвращает значение степени введенное в консоль
     *
     * @return значение степени
     * @throws IOException если введены некорректные данные
     */
    private int inputRow() throws IOException {
        int row;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите степень строки -> ");
        if (sc.hasNextInt()) {
            row = sc.nextInt();
        } else {
            throw new IOException("Ошибка. Введены некорректные данные.");
        }

        return row;
    }

    /**
     * Возвращает степень строки
     *
     * @param line строка
     * @param row  степень строки
     * @return результат возведения в степень
     */
    private String row(String line, int row) {
        StringBuilder builder = new StringBuilder();
        if (row >= 0) {
            builder.append(String.valueOf(line).repeat(row));
        } else {
            builder.append(sqrt(line, row));
        }

        return builder.toString();
    }

    /**
     * Возвращает корень строки
     *
     * @param line строка
     * @param row  степень строки
     * @return результат вычисления
     */
    private String sqrt(String line, int row) {
        String result = "NO SOLUTION";
        int lengthLine = line.length();
        row = -row;
        if (lengthLine % row == 0) {
            String sourceString = line.substring(0, lengthLine / row);
            if (line.equals(row(sourceString, row))) {
                result = sourceString;
            }
        }
        return result;
    }

    /**
     * Возвращает строку, введенную в консоли
     *
     * @return строка, введенная в консоль
     */
    private String inputLine() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку -> ");

        return sc.nextLine();
    }
}

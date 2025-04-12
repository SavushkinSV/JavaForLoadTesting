package module2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Правила игры
 * Компьютер задумывает четыре различные цифры из 0,1,2,...9. Игрок делает ходы, чтобы узнать эти цифры и их порядок.
 * Каждый ход состоит из четырёх цифр, 0 может стоять на первом месте.
 * В ответ компьютер показывает число отгаданных цифр, стоящих на своих местах (число быков) и число отгаданных цифр, стоящих не на своих местах (число коров).
 * <p>
 * Пример
 * Компьютер задумал 0834. *
 * Игрок сделал ход 8134. *
 * Компьютер ответил: 2 быка (цифры 3 и 4) и 1 корова (цифра 8).
 */

public class BullsAndCows {

    private String randomValue;
    private String inputValue;
    private int turn = 1;
    boolean win = false;

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.generateValues();
        while (!bullsAndCows.win) {
            if (bullsAndCows.inputValue()) {
                bullsAndCows.turn++;
                bullsAndCows.checkInputValue();
            }
        }
    }

    /**
     * Генерирует значение из четырех неповторяющихся цифр и сохраняет в переменную {@code randomValue}
     */
    private void generateValues() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> values = new HashSet<>();

        Random random = new Random();
        int value;
        while (values.size() < 4) {
            value = random.nextInt(10);
            if (values.add(value)) {
                sb.append(value);
            }
        }

        randomValue = sb.toString();
        System.out.println("Компьютер загадал цифры. " + sb);
    }

    /**
     * Служит для ввода строки из консоли
     * @return {@code true} если введенная строка соответствует требованиям
     */
    private boolean inputValue() {
        System.out.print(turn + " ход. Введите 4 неповторяющиеся цифры -> ");
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        return validateInputLine(inputLine);
    }

    /**
     * Проверяет введенную строку на соответствие требованиям (содержит цифры и длина равна 4)
     *
     * @param inputLine введенное значение
     * @return {@code true} если введенное значение соответствует требованиям
     */
    private boolean validateInputLine(String inputLine) {
        boolean result = false;
        if (inputLine.length() == 4 && inputLine.matches("\\d+")) {
            Set<Character> set = new HashSet<>();
            for (char c : inputLine.toCharArray()) {
                set.add(c);
            }
            if (set.size() == 4) {
                result = true;
            }
        }
        if (result) {
            inputValue = inputLine;
        } else {
            System.out.println("Введены некорректные данные.");
        }

        return result;
    }

    /**
     * Проверяет введенное значение {@code inputValue} с загаданным {@code randomValue}
     */
    private void checkInputValue() {
        int countBulls = 0;
        int countCows = 0;
        int index;

        for (index = 0; index < 4; index++) {
            char charFromInputValue = inputValue.charAt(index);
            for (int i = 0; i < 4; i++) {
                if (charFromInputValue == randomValue.charAt(i)) {
                    if (i == index) {
                        countBulls++;
                    } else {
                        countCows++;
                    }
                }
            }
        }
        if (countBulls == 4) {
            win = true;
            System.out.println("Поздравляю. Вы отгадали число.");
        } else {
            printBulls(countBulls);
            printCows(countCows);
        }
    }

    /**
     * Выводит в консоль {@code bulls} в зависимости от количества
     *
     * @param bulls количество быков
     */
    private void printBulls(int bulls) {
        System.out.print(bulls);
        switch (bulls) {
            case 0:
                System.out.print(" быков, ");
                break;
            case 1:
                System.out.print(" бык, ");
                break;
            default:
                System.out.print(" быка, ");
        }

    }

    /**
     * Выводит в консоль {@code cows} в зависимости от количества
     *
     * @param cows количество коров
     */
    private void printCows(int cows) {
        System.out.print(cows);
        switch (cows) {
            case 0:
                System.out.println(" коров.");
                break;
            case 1:
                System.out.println(" корова.");
                break;
            default:
                System.out.println(" коровы.");
        }
    }
}

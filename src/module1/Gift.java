package module1;

import java.io.IOException;
import java.util.Scanner;

/**
 * На вход программы подаётся 4 числа: вес подарка, вес апельсина, вес яблока, вес груши.
 * Каждый подарок состоит из произвольного набора апельсинов, яблок и груш, необходимо
 * вывести количество способов составить подарок с заданными весом.
 * Пример:
 * Вход программы: 40 25 15 10
 * Ответ: 3
 * Пояснение:
 * 1 вариант - 1 апельсин весом 25 и 1 яблоко весом 15.
 * 2 вариант - 2 яблока весом 15 и 1 груша.
 * 3 вариант - 4 груши.
 */

public class Gift {
    public static void main(String[] args) {
        int weightGift = 0;
        int weightOrange = 0;
        int weightApple = 0;
        int weightPear = 0;
        try {
            System.out.print("Введите вес подарка -> ");
            weightGift = getWeight();
            System.out.print("Введите вес апельсина -> ");
            weightOrange = getWeight();
            System.out.print("Введите вес яблока -> ");
            weightApple = getWeight();
            System.out.print("Введите вес груши -> ");
            weightPear = getWeight();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        int maxNumbersOfOrange = getMaxNumbers(weightOrange, weightGift);
        int maxNumbersOfApple = getMaxNumbers(weightApple, weightGift);
        int weightRemainderInGift;

        int countVariants = 0;
        for (int weightOrangesInGift = 0; weightOrangesInGift <= maxNumbersOfOrange * weightOrange; weightOrangesInGift += weightOrange) {
            for (int weightApplesInGift = 0; weightApplesInGift <= maxNumbersOfApple * weightApple; weightApplesInGift += weightApple) {
                weightRemainderInGift = weightGift - weightOrangesInGift - weightApplesInGift;
                if (weightRemainderInGift >= 0) {
                    int orange = getNumbers(weightOrangesInGift, weightOrange);
                    int apple = getNumbers(weightApplesInGift, weightApple);
                    int pear = getNumbers(weightRemainderInGift, weightPear);
                    if (orange * weightOrange + apple * weightApple + pear * weightPear == weightGift) {
                        countVariants++;
                    }
                }
            }
        }
        System.out.println(countVariants);
    }

    private static int getNumbers(int weight, int weightOneComponent) {
        int result = 0;
        if (weightOneComponent != 0) {
            result = weight / weightOneComponent;
        }

        return result;
    }

    private static int getMaxNumbers(int weightComponent, int weightGift) {
        int result = 0;
        if (weightComponent != 0) {
            result = weightGift / weightComponent;
        }

        return result;
    }

    private static int getWeight() throws IOException {
        int number;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            throw new IOException("Ошибка. Некорректные данные.");
        }
        if (number <= 0) {
            throw new IOException("Ошибка. Число должно быть больше 0.");
        }

        return number;
    }
}

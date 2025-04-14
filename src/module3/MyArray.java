package module3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Вывод массива в обратном порядке. Метод private void printReverse(int[] array)
 * Сортировка массива пузырьком.
 * Бинарный поиск.
 * Задача сапёр (*).
 * Вывод массива по спирали (*).
 */

public class MyArray {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        int[] myArray = array.getArray();
        System.out.println("Исходный массив: " + Arrays.toString(myArray));
        System.out.print("Вывод массива в обратном порядке: ");
        array.printReverse(myArray);
        System.out.println("Сортировка массива.");
        array.sort(myArray);
        System.out.println("Вывод массива после сортировки: " + Arrays.toString(myArray));
        try {
            int number = array.inputNumber();
            array.find(number, myArray);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void find(int number, int[] array) {
        int indexFound = -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == number) {
                indexFound = mid;
                break;
            }
            if (array[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (indexFound < 0) {
            System.out.println("Значение не найдено.");
        } else {
            System.out.println("Значение найдено. Индекс " + indexFound + ".");
        }
    }

    private int inputNumber() throws IOException {
        System.out.print("Введите число для поиска в массиве -> ");
        Scanner scanner = new Scanner(System.in);
        int result;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
        } else {
            throw new IOException("Введены некорректные данные.");
        }

        return result;
    }

    /**
     * Возвращает случайно сгенерированный массив {@code int[]}
     *
     * @return массив {@code int[]}
     */
    private int[] getArray() {
        Random random = new Random();
        int size = random.nextInt(20) + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(20);
        }

        return array;
    }

    /**
     * Выводит в консоль массив {@code array} в обратном порядке
     *
     * @param array массив
     */
    private void printReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Выполняет пузырьковую сортировку массива {@code array}
     *
     * @param array массив
     */
    private void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}

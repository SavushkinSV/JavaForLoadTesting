package module2;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * На вход подаётся текст, слова отделяются пробелами, для каждого слова необходимо вывести количество его повторений.
 * <p>
 * Пример.
 * привет текст проблема язык программирование курс идея текст заглушка утечка курс цикл текст апрель
 */

public class WordClass1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст для подсчёта количества разных слов:");
        String line = sc.nextLine();
        sc.close();
        Map<String, Long> wordCounts = Arrays.stream(line.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        wordCounts.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}

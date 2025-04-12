package module2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * На вход подаётся текст, слова отделяются пробелами, для каждого слова необходимо вывести количество его повторений.
 * <p>
 * Пример.
 * привет текст проблема язык программирование курс идея текст заглушка утечка курс цикл текст апрель
 */

public class WordCount {
    public static void main(String[] args) {
        WordCount wc = new WordCount();
        String line = wc.inputLine();
        wc.countNumberOfWords(line);

    }

    private String inputLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст для подсчёта количества разных слов:");
        String line = sc.nextLine();
        sc.close();

        return line;
    }

    private void countNumberOfWords(String line) {
        if (line.isEmpty()) return;

        String[] arrayWords =  line.split(" ");




        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : arrayWords) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        printNumberOfWords(wordCountMap);


    }

    private void printNumberOfWords(Map<String, Integer> wordCountMap) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }


}

package module1;

/**
 * Вывести числа от 1000 до 1 с шагом -2.
 */

public class Numbers {
    public static void main(String[] args) {
        for (int i = 1000; i > 0; i -= 2) {
            System.out.println(i);
        }
    }
}

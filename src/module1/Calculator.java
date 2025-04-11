package module1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Калькулятор принимает на вход два числа и знак операции (+, -, *, /),
 * если был подан другой знак выводится ошибка.
 * В результате вычислений выводится фраза подобного формата: 2 + 3 = 5
 * Программа работает до тех пор, пока пользователь не напишет команду stop.
 */

public class Calculator {
    public static void main(String[] args) {
        double result;
        try {
            double number1 = getNumber();
            double number2 = getNumber();
            char operation = getOperation();
            result = calculate(number1, number2, operation);
            System.out.println("Результат операции: " + result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static double calculate(double number1, double number2, char operation) throws IOException {
        double result;
        switch (operation) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> result = number1 / number2;
            default -> throw new IOException("Ошибка. Некорректная операция.");
        }

        return result;
    }

    private static char getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите операцию над числами -> ");
        char operation = 0;
        if (sc.hasNext()) {
            operation = sc.next().charAt(0);
        }
        sc.close();

        return operation;
    }

    static double getNumber() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число -> ");
        double number;
        if (sc.hasNextDouble()) {
            number = sc.nextDouble();
        } else {
            throw new IOException("Ошибка. Некорректное число");
        }
        return number;
    }

}

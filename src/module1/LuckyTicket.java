package module1;

import java.io.IOException;
import java.util.Scanner;

public class LuckyTicket {
    public static void main(String[] args) {
        String ticket = getTicket();

        try {
            if (checkTicket(ticket)) {
                System.out.println("Счастливый билет.");
            } else {
                System.out.println("Обычный билет.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Возвращает {@code true} если сумма начальных цифр номера билета равняется сумме
     * конечных цифр номера билета
     *
     * @param ticket номер билета
     * @return {@code true} если билет счастливый
     * @throws IOException если в номере билета есть символы
     */
    private static boolean checkTicket(String ticket) throws IOException {
        boolean result = false;
        int NumberFromBeginning;
        int NumberFromEnd;
        int sumBeginning = 0;
        int sumEnd = 0;

        if (!ticket.isEmpty()) {
            for (int i = 0; i <= ticket.length() / 2; i++) {
                NumberFromBeginning = getNumber(ticket.charAt(i));
                NumberFromEnd = getNumber(ticket.charAt(ticket.length() - 1 - i));
                sumBeginning += NumberFromBeginning;
                sumEnd += NumberFromEnd;
            }
            if (sumBeginning == sumEnd && ticket.length() % 2 == 0) result = true;
        }

        return result;
    }

    private static int getNumber(char ch) throws IOException {
        int number = Character.getNumericValue(ch);
        if (number < 0 || number > 9) {
            throw new IOException("Ошибка. Некорректный номер билета.");
        }

        return number;
    }

    private static String getTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер билета -> ");
        String line = "";
        if (scanner.hasNext()) {
            line = scanner.next();
        }

        return line;
    }
}

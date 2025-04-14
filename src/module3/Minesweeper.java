package module3;

import java.io.*;

/**
 * Ссылка на задачу: <a href="https://acmp.ru/index.asp?main=task&id_task=234">...</a>
 */

public class Minesweeper {

    private int[][] field;
    private int row;
    private int col;
    private int numberOfMines;

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.readConfigFile();
        minesweeper.writeField();
    }

    /**
     * Записывает в файл соответствующие строки карты
     */
    private void writeField() {
        String filePath = "src/module3/output.txt";

        try (FileWriter writer = new FileWriter(filePath, false)) {
            char ch;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (field[i][j] == 1) {
                        ch = getCharToWrite(-1);
                    } else {
                        int numberOfMinesAround = getNumberOfMinesAround(i, j);
                        ch = getCharToWrite(numberOfMinesAround);
                    }
                    writer.write(ch);
                }
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Возвращает символ на основании количества мин вокруг ячейки для записи в файл
     *
     * @param numberOfMinesAround число мин вокруг ячейки
     * @return символ для записи в файл
     */
    private char getCharToWrite(int numberOfMinesAround) {
        char ch = switch (numberOfMinesAround) {
            case 0 -> '.';
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 6 -> '6';
            case 7 -> '7';
            case 8 -> '8';
            default -> '*';
        };

        return ch;
    }

    /**
     * Возвращает количество мин находящихся рядом с ячейкой
     *
     * @param posRow позиция строки
     * @param posCol позиция колонки
     * @return число мин рядом с ячейкой
     */
    private int getNumberOfMinesAround(int posRow, int posCol) {
        int count = 0;
        for (int i = posRow - 1; i <= posRow + 1; i++) {
            for (int j = posCol - 1; j <= posCol + 1; j++) {
                if (i == posRow && j == posCol) continue;
                if (!isOutOfBounds(i, j)) {
                    if (field[i][j] == 1) count++;
                }
            }
        }

        return count;
    }

    /**
     * Проверяет значение с координатами на нахождение в пределах игрового поля
     *
     * @param posRow позиция строки
     * @param posCol позиция колонки
     * @return {@code true} если значение находится вне пределах игрового поля
     */
    private boolean isOutOfBounds(int posRow, int posCol) {
        return posRow < 0 || posRow >= row || posCol < 0 || posCol >= col;
    }

    /**
     * Открывает файл конфигурации игрового поля и сохраняет настройки в переменные
     */
    private void readConfigFile() {
        String filePath = "src/module3/input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String configLine = reader.readLine();
            settingConfiguration(configLine);
            int currentRow;
            int currentCol;
            field = new int[row][col];
            for (int i = 1; i <= numberOfMines; i++) {
                String line = reader.readLine();
                String[] mineCoordinates = line.split(" ");
                currentRow = Integer.parseInt(mineCoordinates[0]) - 1;
                currentCol = Integer.parseInt(mineCoordinates[1]) - 1;
                field[currentRow][currentCol] = 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Парсит входящую строку конфигурации и сохраняет значения в переменные
     *
     * @param line строка конфигурации
     */
    private void settingConfiguration(String line) {
        String[] config = line.split(" ");
        row = Integer.parseInt(config[0]);
        col = Integer.parseInt(config[1]);
        numberOfMines = Integer.parseInt(config[2]);
    }
}

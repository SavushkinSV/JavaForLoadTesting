package module3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * На вход подаётся одно число n = размеру квадратной матрицы, на выходе должен получиться массив
 * из чисел от 1 до n выведенный по спирали.
 */

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        try {
            int n = matrix.inputNumber();
            int[][] spiralMatrix = getSpiralSquareMatrix(n);
            for (int i = 0; i < Math.abs(n); i++)
                System.out.println(Arrays.toString(spiralMatrix[i]));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Возвращает двумерный массив с количеством {@code size} строк и колонок.
     * Если {@code size} положительное, то вращение производится по часовой стрелке.
     *
     * @param size размерность двумерного массива
     * @return двумерный массив
     */
    private static int[][] getSpiralSquareMatrix(int size) {
        int rotation = 1;
        if (size < 0) {
            size = -size;
            rotation = -rotation;
        }

        return getSpiralMatrix(size, size, rotation);
    }

    /**
     * Возвращает двумерный массив с количеством {@code row} строк и {@code col} колонок.
     * Ячейки массива заполняются значениями от 1 по спирали в зависимости от параметра {@code rotation}.
     * Если {@code rotation} положительное, то вращение производится по часовой стрелке.
     *
     * @param row      количество строк в двумерном массиве
     * @param col      количество столбцов в двумерном массиве
     * @param rotation вращение
     * @return двумерный массив {@code int[][]}
     */
    private static int[][] getSpiralMatrix(int row, int col, int rotation) {
        int[][] matrix = new int[row][col];
        int count = 1;
        int x, y, d_row, d_col;
        if (rotation >= 0) {
            x = -1;
            y = 0;
            d_row = 0;
            d_col = 1;
        } else {
            System.out.println("rotation");
            x = 0;
            y = -1;
            d_row = 1;
            d_col = 0;
        }
        while (count <= row * col) {
            if ((0 <= x + d_col && x + d_col < col) && (0 <= y + d_row && y + d_row < row) && (matrix[y + d_row][x + d_col] == 0)) {
                x += d_col;
                y += d_row;
                matrix[y][x] = count;
                count++;
            } else {
                if (d_col == 1) {
                    d_col = 0;
                    d_row = 1;
                } else if (d_row == 1) {
                    d_row = 0;
                    d_col = -1;
                } else if (d_col == -1) {
                    d_col = 0;
                    d_row = -1;
                } else if (d_row == -1) {
                    d_row = 0;
                    d_col = 1;
                }
            }
        }

        return matrix;
    }

    private int inputNumber() throws IOException {
        System.out.print("Введите число для задания размера квадратной матрицы -> ");
        Scanner scanner = new Scanner(System.in);
        int result;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();
        } else {
            throw new IOException("Введены некорректные данные.");
        }

        return result;
    }
}

package module3;

import java.io.*;
import java.util.Arrays;

public class Minesweeper {

    private int[][] field;
    private int row;
    private int col;
    private int numberOfMines;

    public static void main(String[] args) {

        Minesweeper minesweeper = new Minesweeper();
        minesweeper.readConfigFile();
        for (int i = 0; i < minesweeper.row; i++) {
            System.out.println(Arrays.toString(minesweeper.field[i]));
        }
        minesweeper.writeField();

    }

    private void writeField() {
        String filePath = "src/module3/output.txt";

        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {


                }
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

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
//                System.out.println(currentRow + ", " + currentCol);
                field[currentRow][currentCol] = 1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void settingConfiguration(String line) {
        String[] config = line.split(" ");
        row = Integer.parseInt(config[0]);
        col = Integer.parseInt(config[1]);
        numberOfMines = Integer.parseInt(config[2]);
        System.out.println("row=" + row + ", col=" + col + ", numberOfMines=" + numberOfMines + ".");
    }


}

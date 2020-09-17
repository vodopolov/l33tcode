package com.vodopolov.validSudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anton on 16.08.2019.
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] example1 = new char[9][9];
        example1[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        example1[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        example1[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        example1[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        example1[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        example1[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        example1[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        example1[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        example1[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        Sudoku validator = new Sudoku();

        System.out.println("Example 1 check result: " + validator.isValidSudoku(example1));

        char[][] example2 = new char[9][9];
        example2[0] = new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        example2[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        example2[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        example2[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        example2[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        example2[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        example2[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        example2[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        example2[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println("Example 2 check result: " + validator.isValidSudoku(example2));

        char[][] example3 = new char[9][9];
        example3[0] = new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'};
        example3[1] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        example3[2] = new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'};
        example3[3] = new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'};
        example3[4] = new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'};
        example3[5] = new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'};
        example3[6] = new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'};
        example3[7] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        example3[8] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Example 3 check result: " + validator.isValidSudoku(example3));

        char[][] example4 = new char[9][9];
        example3[0] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        example3[1] = new char[]{'.', '.', '2', '.', '.', '.', '.', '.', '.'};
        example3[2] = new char[]{'.', '.', '.', '.', '.', '2', '7', '1', '.'};
        example3[3] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        example3[4] = new char[]{'.', '2', '.', '.', '.', '.', '.', '.', '.'};
        example3[5] = new char[]{'.', '5', '.', '.', '.', '.', '.', '.', '.'};
        example3[6] = new char[]{'.', '.', '.', '.', '9', '.', '.', '.', '8'};
        example3[7] = new char[]{'.', '.', '.', '.', '.', '1', '6', '.', '.'};
        example3[8] = new char[]{'.', '.', '.', '.', '6', '.', '.', '.', '.'};
        System.out.println("Example 4 check result: " + validator.isValidSudoku(example3));
    }

    private static final int BORDER_STEP = 3;

    private ArrayList<SudokuCube> cubes;

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Integer>> verticalLines = new HashMap<>();
        cubes = new ArrayList<>();
        for (int y = 0; y < board.length; y++) {
            //Create vertical line
            Set<Integer> horizontalLine = new HashSet<>();

            for (int x = 0; x < board[y].length; x++) {
                //Get or create vertical line
                Set<Integer> verticalLine;
                if (verticalLines.size() <= x) {
                    verticalLine = new HashSet<>();
                    verticalLines.put(x, verticalLine);
                } else
                    verticalLine = verticalLines.get(x);
                //Get or create cube
                SudokuCube cube = this.getCube(y, x);

                //Continue if char is empty
                if (board[y][x] == '.')
                    continue;

                //Check
                Integer value = Integer.parseInt(String.valueOf(board[y][x]));
                if (!horizontalLine.add(value) || !verticalLine.add(value))
                    return false;
                if (!cube.checkAndAddValue(value))
                    return false;
            }
        }
        return true;
    }

    private SudokuCube getCube(int y, int x) {
        for (SudokuCube cube : cubes) {
            if (cube.isInRange(y, x)) return cube;
        }
        SudokuCube newCube = new SudokuCube(y, x, y + BORDER_STEP, x + BORDER_STEP);
        this.cubes.add(newCube);
        return newCube;
    }

    private class SudokuCube {
        final int xBorderStart;
        final int yBorderStart;
        final int xBorderFinish;
        final int yBorderFinnish;
        private Set<Integer> _values;

        private SudokuCube(int yBorderStart, int xBorderStart, int yBorderFinnish, int xBorderFinish) {
            this.xBorderStart = xBorderStart;
            this.yBorderStart = yBorderStart;
            this.xBorderFinish = xBorderFinish;
            this.yBorderFinnish = yBorderFinnish;
            this._values = new HashSet<>();
        }

        boolean checkAndAddValue(int value) {
            return this._values.add(value);
        }

        boolean isInRange(int y, int x) {
            return this.xBorderStart <= x && x < this.xBorderFinish
                    && this.yBorderStart <= y && y < this.yBorderFinnish;
        }
    }
}

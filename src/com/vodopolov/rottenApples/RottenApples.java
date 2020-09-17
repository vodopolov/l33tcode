package com.vodopolov.rottenApples;

/**
 * Created by Anton on 14.03.2020.
 */
public class RottenApples {
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public static void main(String[] args) {
        RottenApples inst = new RottenApples();
        System.out.println(inst.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(inst.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        return backtrack(grid, 0, true);
    }

    private int backtrack(int[][] grid, int stepsCounter, boolean wasChanged) {
        if (checkIfAllRotten(grid)) return stepsCounter;
        if (!wasChanged) return -1;
        wasChanged = false;


        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                newGrid[i][j] = grid[i][j];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == FRESH && checkIfAdjacentToRotten(grid, i, j)) {
                    newGrid[i][j] = ROTTEN;
                    wasChanged = true;
                }
            }
        }
        return backtrack(newGrid, stepsCounter + 1, wasChanged);
    }

    private boolean checkIfAdjacentToRotten(int[][] grid, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == ROTTEN) return true;
        if (j - 1 >= 0 && grid[i][j - 1] == ROTTEN) return true;
        if (i + 1 < grid.length && grid[i + 1][j] == ROTTEN) return true;
        if (j + 1 < grid[i].length && grid[i][j + 1] == ROTTEN) return true;
        return false;
    }

    private boolean checkIfAllRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == FRESH) return false;
            }
        }
        return true;
    }
}

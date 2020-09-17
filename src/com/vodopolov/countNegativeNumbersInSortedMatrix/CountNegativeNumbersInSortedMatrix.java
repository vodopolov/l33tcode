package com.vodopolov.countNegativeNumbersInSortedMatrix;

/**
 * Created by Anton on 19.02.2020.
 */
public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix inst = new CountNegativeNumbersInSortedMatrix();
        int[][] arr = { { 3, 2 }, { -1, -2 } };
        System.out.println(inst.countNegatives(arr));
    }

    public int countNegatives(int[][] grid) {
        int counter = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) counter++;
                else break;
            }
        }
        return counter;
    }
}
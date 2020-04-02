package com.vodopolov.floodFill;

/**
 * Created by Anton on 02.04.2020.
 */
public class FloodFill {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(new int[][]{{0,0,0},{0,1,1}}, 1, 1, 1);
        for (int[] i : result) {
            for (int y : i) {
                System.out.print(y);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;
        checkAndFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void checkAndFill(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) return;
        if (image[x][y] != oldColor) return;
        image[x][y] = newColor;
        checkAndFill(image, x + 1, y, oldColor, newColor);
        checkAndFill(image, x - 1, y, oldColor, newColor);
        checkAndFill(image, x, y + 1, oldColor, newColor);
        checkAndFill(image, x, y - 1, oldColor, newColor);
    }
}

package com.juneContest;

import java.util.HashSet;
import java.util.Objects;

public class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {

        int maxSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxSize = Math.max(process(grid, i, j, 0), maxSize);
            }
        }
        return maxSize;
    }

    private int process(int[][] grid, int x, int y, int size) {
        Coordinate coordinate = new Coordinate(x, y);
        if (((grid.length - 1) < x)
            || (0 > x)
            || (0 > y)
            || ((grid[x].length - 1) < y)
            || grid[x][y] == 0)
                return size;
        size++;
        size = process(grid, x + 1, y, size);
        size = process(grid, x - 1, y, size);
        size = process(grid, x, y - 1, size);
        size = process(grid, x, y + 1, size);
        return size;
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

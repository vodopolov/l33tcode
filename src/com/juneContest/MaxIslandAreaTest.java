package com.juneContest;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MaxIslandAreaTest {

    @org.junit.jupiter.api.Test
    void maxAreaOfIsland() {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxIslandArea islandArea = new MaxIslandArea();
        Assertions.assertEquals(islandArea.maxAreaOfIsland(grid), 6);

        int[][] secondGrid = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
        Assertions.assertEquals(islandArea.maxAreaOfIsland(secondGrid), 0);
    }

    @org.junit.jupiter.api.Test
    void areaOfIsland() {
        int[][] grid = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };
        MaxIslandArea area = new MaxIslandArea();
        Assertions.assertEquals(25, area.maxAreaOfIsland(grid));
    }
}
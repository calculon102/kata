package de.pixelgerecht.kata.gameoflife;

import java.util.Random;

/**
 * Creates patterns as seen in https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life.
 */
public class Patterns {
    Grid block() {
        return Grid.of(new boolean[][]{
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        });
    }

    Grid boat() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false},
                {false, true, true, false, false},
                {false, true, false, true, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
        });
    }

    Grid tub() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, true, false, true, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
        });
    }

    public Grid blinker1() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        });
    }

    Grid blinker2() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
        });
    }

    public Grid toad1() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, true, true, true, false},
                {false, true, true, true, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        });
    }

    Grid toad2() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, false, true, false, false},
                {false, true, false, false, true, false},
                {false, true, false, false, true, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},
        });
    }

    public Grid beacon1() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false, false},
                {false, true, true, false, false, false},
                {false, true, false, false, false, false},
                {false, false, false, false, true, false},
                {false, false, false, true, true, false},
                {false, false, false, false, false, false},
        });
    }

    Grid beacon2() {
        return Grid.of(new boolean[][]{
                {false, false, false, false, false, false},
                {false, true, true, false, false, false},
                {false, true, true, false, false, false},
                {false, false, false, true, true, false},
                {false, false, false, true, true, false},
                {false, false, false, false, false, false},
        });
    }

    public Grid random(int width, int height) {
        boolean[][] cells = new boolean[width][height];

        Random r = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = r.nextBoolean();
            }
        }

        return Grid.of(cells);
    }
}

package de.pixelgerecht.kata.gameoflife;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

/**
 * Timeless grid of cells.
 */
public class Grid {
    private final Cell[][] cells;

    static Grid of(boolean[][] cells) {
        assertGreaterZero("width", cells.length);
        assertGreaterZero("height", cells[0].length);

        Cell[][] state = new Cell[cells.length][cells[0].length];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                state[x][y] = new Cell(cells[x][y]);
            }
        }

        return new Grid(state);
    }

    static Grid of(Cell[][] cells) {
        assertGreaterZero("width", cells.length);
        assertGreaterZero("height", cells[0].length);

        // Defensive copy
        Cell[][] state = new Cell[cells.length][cells[0].length];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                state[x][y] = new Cell(cells[x][y] != null && cells[x][y].isAlive());
            }
        }

        return new Grid(state);
    }

    private static void assertGreaterZero(String name, int value) {
        if (value < 1) {
            throw new IllegalArgumentException(name + " must be greater 0!");
        }
    }

    private Grid(Cell[][] state) {
        this.cells = state;
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    public boolean isAlive(int x, int y) {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight()
                && cells[x][y] != null
                && cells[x][y].isAlive();
    }

    int countNeighbours(int px, int py) {
        int result = 0;

        for (int x = px - 1; x <= px + 1; x++) {
            for (int y = py - 1; y <= py + 1; y++) {
                if (x == px && y == py) {
                    continue;
                }

                if (isAlive(x, y)) {
                    result += 1;
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder((getWidth()) + 1 * getHeight());


        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                sb.append(isAlive(x, y) ? '1' : '0');
            }

            sb.append(lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        return Arrays.deepEquals(cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }
}

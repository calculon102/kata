package de.pixelgerecht.kata.gameoflife;

/**
 * Rules for this game of life.
 */
public class Rules {
    Cell apply(Cell cell, int neighbours) {
        return apply(cell.isAlive(), neighbours);
    }

    Cell apply(boolean isAlive, int neighbours) {
        boolean becomesNewLife = !isAlive && neighbours == 3;
        if (becomesNewLife) {
            return new Cell(true);
        }

        boolean isOverUnderCrowded = isAlive && !(neighbours == 2 || neighbours == 3);
        if (isOverUnderCrowded) {
            return new Cell(false);
        }

        return new Cell(isAlive);
    }
}

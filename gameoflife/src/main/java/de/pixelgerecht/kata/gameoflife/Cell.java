package de.pixelgerecht.kata.gameoflife;

/**
 * Represents a single cell with its living state.
 */
class Cell {
    private final boolean alive;

    Cell(boolean alive) {
        this.alive = alive;
    }

    boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return alive ? "Alive" : "Dead";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return (alive ? 1 : 0);
    }
}

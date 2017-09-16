package de.pixelgerecht.kata.gameoflife;

/**
 * Grid with a set of rules for evolution that may evolve into a further Generation-state.
 */
public class Generation {
    private final Grid grid;
    private final Rules rules;

    public Generation(Grid grid, Rules rules) {
        this.grid = grid;
        this.rules = rules;
    }

    public Generation evolve() {
        int width = grid.getWidth();
        int height = grid.getHeight();

        Cell[][] evolved = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                evolved[x][y] = rules.apply(grid.isAlive(x, y), grid.countNeighbours(x, y));
            }
        }

        Grid evolvedGrid = Grid.of(evolved);
        return new Generation(evolvedGrid, rules);
    }

    public Grid getGrid() {
        return grid;
    }
}

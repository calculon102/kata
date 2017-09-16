package de.pixelgerecht.kata.gameoflife;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GridTest {

    @Test
    public void initializesWithCellArray() throws Exception {
        int expectedWidth = 3;
        int expectedHeight = 4;

        Cell[][] cells = new Cell[expectedWidth][expectedHeight];

        Grid grid = Grid.of(cells);

        assertThat(grid.getWidth(), equalTo(expectedWidth));
        assertThat(grid.getHeight(), equalTo(expectedHeight));
    }

    @Test
    public void initializesWithBooleanArray() throws Exception {
        Grid grid = create3x3StarGrid();

        assertThat(grid.getWidth(), equalTo(3));
        assertThat(grid.getHeight(), equalTo(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void widthMustBeGreaterThanZero() throws Exception {
        Grid.of(new Cell[0][1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void heightMustBeGreaterThanZero() throws Exception {
        Grid.of(new Cell[1][0]);
    }

    @Test
    public void implementsToString() throws Exception {
        Grid grid = create3x3StarGrid();

        String expected = "101" + lineSeparator() + "010" + lineSeparator() + "101" + lineSeparator();

        assertThat(grid.toString(), equalTo(expected));
    }

    @Test
    public void gridsWithSameCellStateAreEqual() throws Exception {
        Grid grid1 = create3x3StarGrid();
        Grid grid2 = create3x3StarGrid();

        assertThat(grid1, equalTo(grid2));
    }

    @Test
    public void accessCellStateOnGrid() throws Exception {
        Cell[][] cells = new Cell[2][2];
        cells[0][0] = new Cell(true);
        cells[1][1] = new Cell(false);

        Grid grid = Grid.of(cells);

        // Null-cells in array are also false
        assertThat(grid.isAlive(0, 0), equalTo(true));
        assertThat(grid.isAlive(0, 1), equalTo(false));
        assertThat(grid.isAlive(1, 0), equalTo(false));
        assertThat(grid.isAlive(1, 1), equalTo(false));
    }

    @Test
    public void cellsOutsideGridAreAlwaysDead() throws Exception {
        Grid grid = Grid.of(new Cell[1][1]);

        assertThat(grid.isAlive(-1, 0), equalTo(false));
        assertThat(grid.isAlive(0, -1), equalTo(false));
        assertThat(grid.isAlive(1, 0), equalTo(false));
        assertThat(grid.isAlive(0, 1), equalTo(false));
    }

    @Test
    public void countsNeighbours() throws Exception {

        Grid empty1x1 = Grid.of(new Cell[1][1]);

        assertThat(empty1x1.countNeighbours(0, 0), equalTo(0));


        Grid full1x1 = createFullGrid(1,1);

        assertThat(full1x1.countNeighbours(0, 0), equalTo(0));
        // Some counts from outside of the grid
        assertThat(full1x1.countNeighbours(-1, 0), equalTo(1));
        assertThat(full1x1.countNeighbours(0, -1), equalTo(1));
        assertThat(full1x1.countNeighbours(-1, -1), equalTo(1));
        assertThat(full1x1.countNeighbours(1, 0), equalTo(1));
        assertThat(full1x1.countNeighbours(0, 1), equalTo(1));
        assertThat(full1x1.countNeighbours(1, 1), equalTo(1));


        Grid empty2x2 = Grid.of(new Cell[2][2]);

        assertThat(empty2x2.countNeighbours(0, 0), equalTo(0));
        assertThat(empty2x2.countNeighbours(0, 1), equalTo(0));
        assertThat(empty2x2.countNeighbours(1, 0), equalTo(0));
        assertThat(empty2x2.countNeighbours(1, 1), equalTo(0));


        Grid full2x2 = createFullGrid(2,2);

        assertThat(full2x2.countNeighbours(0, 0), equalTo(3));
        assertThat(full2x2.countNeighbours(0, 1), equalTo(3));
        assertThat(full2x2.countNeighbours(1, 0), equalTo(3));
        assertThat(full2x2.countNeighbours(1, 1), equalTo(3));

        // Some counts from outside of the grid
        assertThat(full2x2.countNeighbours(2, 2), equalTo(1));
        assertThat(full2x2.countNeighbours(-1, -1), equalTo(1));
        assertThat(full2x2.countNeighbours(0, -1), equalTo(2));


        Grid full3x3 = createFullGrid(3,3);

        assertThat(full3x3.countNeighbours(0, 0), equalTo(3));
        assertThat(full3x3.countNeighbours(1, 0), equalTo(5));
        assertThat(full3x3.countNeighbours(2, 0), equalTo(3));

        assertThat(full3x3.countNeighbours(0, 1), equalTo(5));
        assertThat(full3x3.countNeighbours(1, 1), equalTo(8));
        assertThat(full3x3.countNeighbours(2, 1), equalTo(5));

        assertThat(full3x3.countNeighbours(0, 2), equalTo(3));
        assertThat(full3x3.countNeighbours(1, 2), equalTo(5));
        assertThat(full3x3.countNeighbours(2, 2), equalTo(3));
    }


    private Grid createFullGrid(int w, int h) {
        Cell[][] cells = new Cell[w][h];

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                cells[x][y] = new Cell(true);
            }
        }

        return Grid.of(cells);
    }

    private Grid create3x3StarGrid() {
        boolean[][] cells = new boolean[][] {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        return Grid.of(cells);
    }
}

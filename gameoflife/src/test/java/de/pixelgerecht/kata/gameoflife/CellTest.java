package de.pixelgerecht.kata.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CellTest {

    @Test
    public void canBeAlive() throws Exception {
        Cell cell = new Cell(true);

        assertThat(cell.isAlive(), equalTo(true));
    }

    @Test
    public void canBeDead() throws Exception {
        Cell cell = new Cell(false);

        assertThat(cell.isAlive(), equalTo(false));
    }

    @Test
    public void implementsToString() throws Exception {
        Cell living = new Cell(true);

        assertThat(living.toString(), equalTo("Alive"));

        Cell dead = new Cell(false);

        assertThat(dead.toString(), equalTo("Dead"));
    }

    @Test
    public void equalsOnLivingState() throws Exception {
        Cell living1 = new Cell(true);
        Cell living2 = new Cell(true);
        Cell dead1 = new Cell(false);
        Cell dead2 = new Cell(false);

        assertThat(living1, equalTo(living2));
        assertThat(dead1, equalTo(dead2));
        assertThat(living1, not(equalTo(dead1)));
        assertThat(dead2, not(equalTo(living2)));
    }
}


package de.pixelgerecht.kata.gameoflife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RulesTest {
    private final boolean initialState;
    private final int neighbours;
    private final boolean expectedState;

    @Parameterized.Parameters(name="alive={0} -> alive={2} with {1} neighbours")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, 0, false},
                {true, 1, false},
                {true, 2, true},
                {true, 3, true},
                {true, 4, false},
                {true, 5, false},
                {true, 6, false},
                {true, 7, false},
                {true, 8, false},
                {true, 9, false},
                {false, 0, false},
                {false, 1, false},
                {false, 2, false},
                {false, 3, true},
                {false, 4, false},
                {false, 5, false},
                {false, 6, false},
                {false, 7, false},
                {false, 8, false},
                {false, 9, false},
        });
    }


    public RulesTest(boolean initialState, int neighbours, boolean expectedState) {
        this.initialState = initialState;
        this.neighbours = neighbours;
        this.expectedState = expectedState;
    }

    @Test
    public void applyOnCell() throws Exception {
        Rules rules = new Rules();

        Cell cell = new Cell(initialState);

        Cell result = rules.apply(cell, neighbours);

        assertThat(result, equalTo(new Cell(expectedState)));
    }
}

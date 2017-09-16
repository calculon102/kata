package de.pixelgerecht.kata.gameoflife;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GenerationTest {

    private String name;
    private final Grid initial;
    private final Grid evolved;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {

        Patterns patterns = new Patterns();

        // Some two-period patterns
        return Arrays.asList(new Object[][]{
                {
                        "Still life: Block",
                        patterns.block(),
                        patterns.block()
                },
                {
                        "Still life: Boat",
                        patterns.boat(),
                        patterns.boat()
                },
                {
                        "Still life: Tub",
                        patterns.tub(),
                        patterns.tub()
                },
                {
                        "Oscillators: Blinker",
                        patterns.blinker1(),
                        patterns.blinker2()
                },
                {
                        "Oscillators: Toad",
                        patterns.toad1(),
                        patterns.toad2()
                },
                {
                        "Oscillators: Beacon",
                        patterns.beacon1(),
                        patterns.beacon2()
                },
        });
    }

    public GenerationTest(String name, Grid initial, Grid evolved) {
        this.name = name;
        this.initial = initial;
        this.evolved = evolved;
    }

    @Test
    public void evolves() throws Exception {
        Generation current = new Generation(initial, new Rules());
        Generation next = current.evolve();

        assertThat(name + " did not evolve as expected", next.getGrid(), equalTo(evolved));
    }
}

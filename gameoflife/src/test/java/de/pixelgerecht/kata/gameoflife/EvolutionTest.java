package de.pixelgerecht.kata.gameoflife;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Testing evolution-streams on oscillators.
 */
public class EvolutionTest {
    @Test
    public void createsEndlessStreamOfStillLife() throws Exception {
        Patterns patterns = new Patterns();
        Grid grid = patterns.boat();
        Generation beginning = new Generation(grid, new Rules());

        Evolution evolution = new Evolution(beginning);
        Stream<Generation> progression = evolution.progress();

        List<Generation> generations = progression.limit(6).collect(Collectors.toList());

        assertThat(generations.get(0).getGrid(), equalTo(patterns.boat()));
        assertThat(generations.get(1).getGrid(), equalTo(patterns.boat()));
        assertThat(generations.get(2).getGrid(), equalTo(patterns.boat()));
        assertThat(generations.get(3).getGrid(), equalTo(patterns.boat()));
        assertThat(generations.get(4).getGrid(), equalTo(patterns.boat()));
        assertThat(generations.get(5).getGrid(), equalTo(patterns.boat()));
    }

    @Test
    public void createsEndlessStreamOfTwoPeriodOscillator() throws Exception {
        Patterns patterns = new Patterns();
        Grid grid = patterns.beacon1();
        Generation beginning = new Generation(grid, new Rules());

        Evolution evolution = new Evolution(beginning);
        Stream<Generation> progression = evolution.progress();

        List<Generation> generations = progression.limit(6).collect(Collectors.toList());

        assertThat(generations.get(0).getGrid(), equalTo(patterns.beacon1()));
        assertThat(generations.get(1).getGrid(), equalTo(patterns.beacon2()));
        assertThat(generations.get(2).getGrid(), equalTo(patterns.beacon1()));
        assertThat(generations.get(3).getGrid(), equalTo(patterns.beacon2()));
        assertThat(generations.get(4).getGrid(), equalTo(patterns.beacon1()));
        assertThat(generations.get(5).getGrid(), equalTo(patterns.beacon2()));
    }
}

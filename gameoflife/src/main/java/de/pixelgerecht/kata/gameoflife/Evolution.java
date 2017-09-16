package de.pixelgerecht.kata.gameoflife;

import java.util.stream.Stream;

/**
 * Logical unit of Game of Life.
 */
public class Evolution {
    private Generation beginning;

    public Evolution(Generation beginning) {
        this.beginning = beginning;
    }

    public Stream<Generation> progress() {
        return Stream.iterate(beginning, Generation::evolve);
    }
}

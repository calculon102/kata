package de.pixelgerecht.kata.gameoflife;

import java.util.stream.Stream;

/**
 * Logical unit of Game of Life.
 */
class Evolution {
    private final Generation beginning;

    Evolution(Generation beginning) {
        this.beginning = beginning;
    }

    Stream<Generation> progress() {
        return Stream.iterate(beginning, Generation::evolve);
    }
}

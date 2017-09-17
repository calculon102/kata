package de.pixelgerecht.kata.gameoflife.runner;

import de.pixelgerecht.kata.gameoflife.Generation;

/**
 * Renders current state of a generation.
 */
public interface GenerationRenderer {

    void setGeneration(Generation capture);
}

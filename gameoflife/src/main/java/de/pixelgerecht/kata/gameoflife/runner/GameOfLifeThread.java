package de.pixelgerecht.kata.gameoflife.runner;

import de.pixelgerecht.kata.gameoflife.Generation;
import de.pixelgerecht.kata.gameoflife.Grid;
import de.pixelgerecht.kata.gameoflife.Rules;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class GameOfLifeThread {
    private final ExecutorService executor;
    private final int pauseAfterEvolving;
    private final GenerationRenderer renderer;

    private Future<?> currentGame;

    public GameOfLifeThread(ExecutorService executor, int pauseAfterEvolving, GenerationRenderer renderer) {
        this.executor = executor;
        this.pauseAfterEvolving = pauseAfterEvolving;
        this.renderer = renderer;
    }

     boolean isRunning() {
        return currentGame != null && !currentGame.isCancelled() && !currentGame.isDone();
    }

    public void runWith(Grid grid) {
        cancelCurrentGame();

        currentGame = executor.submit(() -> {
            Generation current = new Generation(grid, new Rules());

            while (true) {
                final Generation toShow = current;

                renderer.setGeneration(toShow);

                if (pauseAfterEvolving > 0) {
                    try {
                        Thread.sleep(pauseAfterEvolving);
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                current = current.evolve();
            }
        });
    }

    public void shutdown() {
        cancelCurrentGame();

        executor.shutdown();
    }

    private void cancelCurrentGame() {
        if (currentGame != null) {
            currentGame.cancel(true);
        }
    }
}

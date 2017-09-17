package de.pixelgerecht.kata.gameoflife.javafx;

import de.pixelgerecht.kata.gameoflife.runner.GameOfLifeThread;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * Scene for Game of Life of menu-bar and display.
 */
class AppScene {
    private final AppDisplay golDisplay = new AppDisplay();
    private final GameOfLifeThread golThread = new GameOfLifeThread(newSingleThreadExecutor(), 100, golDisplay);
    private final AppUserInput golController = new AppUserInput(golThread);

    Scene create() {
        return new Scene(createRootPane());
    }

    private Parent createRootPane() {
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(golController.createMenu());
        borderPane.setCenter(golDisplay.createNode());

        ScrollPane boardScrollPane = new ScrollPane(borderPane);
        boardScrollPane.setFitToHeight(true);
        boardScrollPane.setFitToWidth(true);

        return boardScrollPane;
    }

    void shutdown() {
        golThread.shutdown();
    }
}

package de.pixelgerecht.kata.gameoflife.javafx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

class GameOfLifeScene {
    private final GameOfLifeDisplay golDisplay = new GameOfLifeDisplay();
    private GameOfLifeContoller golController = new GameOfLifeContoller(golDisplay);

    Scene create() {
        return new Scene(createGameOfLifePane());
    }

    private Parent createGameOfLifePane() {
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(golController.createMenu());
        borderPane.setCenter(golDisplay.createPanel());

        ScrollPane boardScrollPane = new ScrollPane(borderPane);
        boardScrollPane.setFitToHeight(true);
        boardScrollPane.setFitToWidth(true);

        return boardScrollPane;
    }

    public void shutdown() {
        golController.shutdown();
    }
}

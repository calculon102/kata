package de.pixelgerecht.kata.gameoflife.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Entry-point for JavaFX-view.
 */
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game of Life");

        GameOfLifeScene golScene = new GameOfLifeScene();

        primaryStage.setOnCloseRequest(e -> golScene.shutdown());

        primaryStage.setScene(golScene.create());
        primaryStage.show();
    }
}

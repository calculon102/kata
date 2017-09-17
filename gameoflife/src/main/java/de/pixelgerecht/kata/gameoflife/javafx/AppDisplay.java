package de.pixelgerecht.kata.gameoflife.javafx;

import de.pixelgerecht.kata.gameoflife.Generation;
import de.pixelgerecht.kata.gameoflife.Grid;
import de.pixelgerecht.kata.gameoflife.runner.GenerationRenderer;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Create user-interface for display of app-state.
 */
class AppDisplay implements GenerationRenderer {
    private final BorderPane pane = new BorderPane();
    private final int minWidth = 640;
    private final int minHeight = 360;

    Node createNode() {
        pane.setMinSize(minWidth, minHeight);
        return pane;
    }

    private void showGrid(Grid toShow) {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(minWidth, minHeight);

        addConstraints(gridPane, toShow);

        for (int x = 0; x < toShow.getWidth(); x++) {
            for (int y = 0; y < toShow.getHeight(); y++) {
                BorderPane field = new BorderPane();

                boolean isAlive = toShow.isAlive(x, y);
                String style = getStyleForState(isAlive);

                field.setStyle(style);

                gridPane.add(field, x, y);
            }
        }

        pane.setCenter(gridPane);
    }

    private String getStyleForState(boolean isAlive) {
        return isAlive
                ? "-fx-background-color: #000000; -fx-border-color: #808080"
                : "-fx-background-color: #ffffff; -fx-border-color: #808080";
    }

    private void addConstraints(GridPane gridPane, Grid toShow) {
        for (int x = 0; x < toShow.getWidth(); x++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0d / (double) toShow.getWidth());
            cc.setMinWidth(6);
            cc.setFillWidth(true);
            gridPane.getColumnConstraints().add(cc);
        }

        for (int y = 0; y < toShow.getHeight(); y++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0d / (double) toShow.getHeight());
            rc.setMinHeight(6);
            rc.setFillHeight(true);
            gridPane.getRowConstraints().add(rc);
        }
    }

    @Override
    public void setGeneration(Generation generation) {
        Platform.runLater(() -> showGrid(generation.getGrid()));
    }
}

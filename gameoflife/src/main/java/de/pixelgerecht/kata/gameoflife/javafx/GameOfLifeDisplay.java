package de.pixelgerecht.kata.gameoflife.javafx;

import de.pixelgerecht.kata.gameoflife.Grid;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class GameOfLifeDisplay {

    private final BorderPane pane = new BorderPane();

    Node createPanel() {
        pane.setMinSize(400, 400);
        return pane;
    }

    void showGrid(Grid toShow) {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 400);

        addConstraints(gridPane, toShow);

        for (int x = 0; x < toShow.getWidth(); x++) {
            for (int y = 0; y < toShow.getHeight(); y++) {
                BorderPane field = new BorderPane();

                String color = toShow.isAlive(x, y) ? "#000000" : "#ffffff";

                field.setStyle("-fx-background-color: " + color + "; -fx-border-color: #808080");
                gridPane.add(field, x, y);
            }
        }

        pane.setCenter(gridPane);
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
}

package de.pixelgerecht.kata.gameoflife.javafx;

import de.pixelgerecht.kata.gameoflife.Generation;
import de.pixelgerecht.kata.gameoflife.Grid;
import de.pixelgerecht.kata.gameoflife.Patterns;
import de.pixelgerecht.kata.gameoflife.Rules;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// TODO Extract Threading-resposibility
class GameOfLifeContoller {
    private final GameOfLifeDisplay golDisplay;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private Future<?> currentGame;

    GameOfLifeContoller(GameOfLifeDisplay golDisplay) {
        this.golDisplay = golDisplay;
    }

    Node createMenu() {
        MenuBar menuBar = new MenuBar();

        Menu menuPattern = new Menu("Patterns");

        MenuItem blinkerItem = new MenuItem("Blinker");
        blinkerItem.setOnAction(e -> startGameOfLife(new Patterns().blinker1()));

        MenuItem beaconItem = new MenuItem("Beacon");
        beaconItem.setOnAction(e -> startGameOfLife(new Patterns().beacon1()));

        MenuItem toadItem = new MenuItem("Toad");
        toadItem.setOnAction(e -> startGameOfLife(new Patterns().toad1()));

        menuPattern.getItems().addAll(blinkerItem, beaconItem, toadItem);


        Menu menuRandom = new Menu("Random");
        MenuItem random16x9Item = new MenuItem("16x9");
        random16x9Item.setOnAction(e -> startGameOfLife(new Patterns().random(16, 9)));

        MenuItem random32x18Item = new MenuItem("32x18");
        random32x18Item.setOnAction(e -> startGameOfLife(new Patterns().random(32, 18)));

        MenuItem random48x27Item = new MenuItem("48x27");
        random48x27Item.setOnAction(e -> startGameOfLife(new Patterns().random(48, 27)));

        menuRandom.getItems().addAll(random16x9Item, random32x18Item, random48x27Item);


        menuBar.getMenus().addAll(menuPattern, menuRandom);

        return menuBar;
    }

    private void startGameOfLife(Grid grid) {
        if (currentGame != null) {
            currentGame.cancel(true);
        }

        currentGame = executor.submit(() -> {
            Generation current = new Generation(grid, new Rules());

            while (true) {
                final Generation toShow = current;

                Platform.runLater(() -> golDisplay.showGrid(toShow.getGrid()));

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }

                current = current.evolve();
            }
        });
    }

    void shutdown() {
        if (currentGame != null) {
            currentGame.cancel(true);
        }
        executor.shutdown();
    }
}

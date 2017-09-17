package de.pixelgerecht.kata.gameoflife.javafx;

import de.pixelgerecht.kata.gameoflife.Grid;
import de.pixelgerecht.kata.gameoflife.Patterns;
import de.pixelgerecht.kata.gameoflife.runner.GameOfLifeThread;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Create user-interface for app-controlling.
 */
class AppUserInput {
    private final GameOfLifeThread golThread;

    AppUserInput(GameOfLifeThread golThread) {
        this.golThread = golThread;
    }

    Node createMenu() {
        MenuBar menuBar = new MenuBar();

        Menu menuPattern = createPatternMenu();
        Menu menuRandom = createRandomMenu();

        menuBar.getMenus().addAll(menuPattern, menuRandom);

        return menuBar;
    }

    private Menu createPatternMenu() {
        Menu menuPattern = new Menu("Patterns");

        MenuItem blinkerItem = new MenuItem("Blinker");
        blinkerItem.setOnAction(e -> startGameOfLife(new Patterns().blinker1()));

        MenuItem beaconItem = new MenuItem("Beacon");
        beaconItem.setOnAction(e -> startGameOfLife(new Patterns().beacon1()));

        MenuItem toadItem = new MenuItem("Toad");
        toadItem.setOnAction(e -> startGameOfLife(new Patterns().toad1()));

        menuPattern.getItems().addAll(blinkerItem, beaconItem, toadItem);
        return menuPattern;
    }

    private Menu createRandomMenu() {
        Menu menuRandom = new Menu("Random");
        MenuItem random16x9Item = new MenuItem("16x9");
        random16x9Item.setOnAction(e -> startGameOfLife(new Patterns().random(16, 9)));

        MenuItem random32x18Item = new MenuItem("32x18");
        random32x18Item.setOnAction(e -> startGameOfLife(new Patterns().random(32, 18)));

        MenuItem random48x27Item = new MenuItem("48x27");
        random48x27Item.setOnAction(e -> startGameOfLife(new Patterns().random(48, 27)));

        menuRandom.getItems().addAll(random16x9Item, random32x18Item, random48x27Item);
        return menuRandom;
    }

    private void startGameOfLife(Grid grid) {
        golThread.runWith(grid);
    }
}

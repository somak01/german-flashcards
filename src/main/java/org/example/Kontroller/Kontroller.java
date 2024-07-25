package org.example.Kontroller;

import org.example.DB.WordSet;
import org.example.GUI.EndingScreen;
import org.example.GUI.GameMenu;
import org.example.GUI.MainMenu;
import org.example.GUI.SettingsMenu;

public class Kontroller {
    private MainMenu main;
    private GameMenu game;
    private SettingsMenu settings;
    private final GameController gc;
    private final EndingScreen endingScreen;

    public Kontroller(MainMenu main, GameMenu game, SettingsMenu settings, EndingScreen endingScreen) {
        if (main != null && game != null && settings != null) {
            this.main = main;
            this.game = game;
            this.settings = settings;
            this.endingScreen = endingScreen;
            gc = new GameController(game, WordSet.getAdjektiv());
        } else throw new NullPointerException("One of Kontroller's argument is null");
    }

    public void configure() {
        main.setExitListener(e -> System.exit(0));
        main.setPlayListener(e -> {main.setVisible(false);game.setVisible(true);});
        main.setSettingsListener(e -> {main.setVisible(false);settings.setVisible(true);});
        settings.setBackBtnActionListener(e -> {settings.setVisible(false);main.setVisible(true);});
        game.setFinishButtonListener(e -> {endingScreen.setVisible(true);endingScreen.setResultText(gc.getResultsAsString());game.setVisible(false);});
        endingScreen.setRestartListener(e -> {endingScreen.setVisible(false);game.setVisible(true); gc.setStartingState();});
        endingScreen.setOkButtonActionListener(e -> {endingScreen.setVisible(false);main.setVisible(true);});
    }


}

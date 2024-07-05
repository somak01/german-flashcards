package org.example;

import org.example.GUI.GameMenu;
import org.example.GUI.MainMenu;
import org.example.GUI.SettingsMenu;

public class Kontroller {
    private MainMenu main;
    private GameMenu game;
    private SettingsMenu settings;

    public Kontroller(MainMenu main, GameMenu game, SettingsMenu settings) {
        if (main != null && game != null && settings != null) {
            this.main = main;
            this.game = game;
            this.settings = settings;
        } else throw new NullPointerException("One of Kontroller's argument is null");
    }
}

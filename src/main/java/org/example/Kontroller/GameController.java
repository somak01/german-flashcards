package org.example.Kontroller;

import org.example.DB.WordSet;
import org.example.GUI.GameMenu;
import org.example.MODEL.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;

public class GameController {
    private final String info = "Translate the word!";
    private final GameMenu gm;
    private final List<Word> words;
    private final Iterator<Word> wordsIter;
    private Word currentWord;

    GameController(GameMenu gm, List<Word> words) {
        this.gm = gm;
        this.words = words;
        wordsIter = words.iterator();
        gm.setNextListener(nextListener());
        gm.setSubmitListener(submitListener());
        setUpCurrentCard();
        setKeyBindings();
        createAndSetupKeyListenerFromGame();
    }
    private ActionListener nextListener() {
        return e -> {
            gm.setNextVisible(false);
            gm.setSubmitVisible(true);
            setUpCurrentCard();
            gm.setBaseColor();
            gm.clearAnswerField();
            gm.setInfoText(info);

        };
    }

    private ActionListener submitListener() {
        return e -> {
            gm.setSubmitVisible(false);
            gm.setNextVisible(true);
            if (checkAnswer()) {
                gm.setBackgroundOnCorrectAnswer();
                gm.setInfoText("Correct Answer!");
            } else {
                gm.setBackgroundOnMistake();
                gm.setInfoText("It should be: " + currentWord.getHungarian());
            }

        };
    }
    public boolean checkAnswer() {
        return currentWord.getHungarian().equals(gm.getAnswer());
    }
    private void setKeyBindings() {
        ActionMap actionMap = gm.getActionMap();
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = gm.getInputMap(condition);

        String vkEnter = "VK_ENTER";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), vkEnter);
        actionMap.put(vkEnter, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("igen");
                gm.doClickFromOutside();
            }
        });

    }
    public void configureButtons() {
    }
    public void createAndSetupKeyListenerFromGame() {
        gm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {

                System.out.println(e.getKeyChar());
            }
        });
    }
    private void updateTask() {
        if (wordsIter.hasNext()) {
            currentWord = wordsIter.next();
        } else {
            System.out.println("The game ended");
        }
    }

    private void setUpCurrentCard() {
        updateTask();
        gm.setWord(currentWord.getGerman());
        gm.clearAnswerField();
    }
}

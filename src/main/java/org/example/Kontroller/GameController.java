package org.example.Kontroller;

import org.example.DB.WordSet;
import org.example.GUI.GameMenu;
import org.example.MODEL.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GameController {
    private final String info = "Translate the word!";
    private final GameMenu gm;
    private List<Word> words;
    private Iterator<Word> wordsIter;
    private Word currentWord;
    private int correctAnswers = 0;
    private boolean isGermanToHungarian = true;

    GameController(GameMenu gm) {
        this.gm = gm;
        gm.setNextListener(nextListener());
        gm.setSubmitListener(submitListener());
        setKeyBindings();
        createAndSetupKeyListenerFromGame();
    }

    public void setWords(List<Word> words) {
        if (words != null) {
            this.words = words;
            wordsIter = words.iterator();
        } else throw new NullPointerException();
    }
    public void setStartingState() {
        Collections.shuffle(words);
        wordsIter = words.iterator();
        setUpCurrentCard();
        System.out.println(isGermanToHungarian);
        correctAnswers = 0;
        gm.setSubmitVisible(true);
        gm.setNextVisible(false);
        gm.setFinishVisible(false);
        gm.setBaseColor();
        gm.setInfoText(info);
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
            if (checkAnswer()) {
                ++correctAnswers;
                gm.setBackgroundOnCorrectAnswer();
                gm.setInfoText("Correct Answer!");
            } else {
                gm.setBackgroundOnMistake();
                if (isGermanToHungarian) {
                    gm.setInfoText("It should be: " + currentWord.getHungarian());
                } else {
                    gm.setInfoText("It should be: " + currentWord.getGerman());
                }
            }
            if (wordsIter.hasNext()) {
                gm.setNextVisible(true);
            } else {
                gm.setFinishVisible(true);
            }


        };
    }
    public void setGermanToHungarian(boolean flag) {
        isGermanToHungarian = flag;
        System.out.println(isGermanToHungarian);
    }
    public boolean checkAnswer() {
        if (isGermanToHungarian) {
            return  !gm.getAnswer().isEmpty() && (currentWord.getHungarian().equalsIgnoreCase(gm.getAnswer()) || currentWord.getHungarian().contains(gm.getAnswer()));
        } else {
            return !gm.getAnswer().isEmpty() && (currentWord.getGerman().equalsIgnoreCase(gm.getAnswer()));
        }
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
        System.out.println("German to hungarian is currently : " + isGermanToHungarian);
        if (isGermanToHungarian) {
            gm.setWord(currentWord.getGerman());
        } else {
            gm.setWord(currentWord.getHungarian());
        }
        gm.clearAnswerField();
    }

    public String getResultsAsString() {
        StringBuilder sb = new StringBuilder();
        System.out.println(words.size());
        sb.append("The result is: ").append(correctAnswers).append("/").append(words.size());
        return sb.toString();
    }
}

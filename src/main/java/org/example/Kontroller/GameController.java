package org.example.Kontroller;

import org.example.DB.WordSet;
import org.example.GUI.GameMenu;
import org.example.MODEL.Word;

import java.awt.event.ActionListener;
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
    public void configureButtons() {
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

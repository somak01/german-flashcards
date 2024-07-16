package org.example.GUI;

import org.example.DB.WordSet;
import org.example.MODEL.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GameMenu extends Menu{
    private final JLabel infoText = new JLabel("Translate the word");
    private final JTextField answerField = new JTextField();
    private final JLabel word = new JLabel();
    private final NextButton nb = new NextButton();
    private final SubmitButton sb = new SubmitButton();
    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();
    private final List<Word> wordList = WordSet.getAdjektiv();
    private final Iterator<Word> wit = wordList.iterator();
    private String solution;
    private final Color correctAnswerColor = new Color(100, 237, 198);
    private final Color mistakeColor = new Color(237, 100, 113);

    public GameMenu() {
        super("Game");
        setLayout(layout);
        generalConstraints();
        titleConstraints();
        add(title,constraints);
        wordConstraints();
        add(word, constraints);
        answerFieldConstraints();
        answerField.setMinimumSize(new Dimension(100, 50));
        answerField.setPreferredSize(new Dimension(100, 50));
        add(answerField, constraints);
        setAfterSubmitTextConstraints();
        add(infoText, constraints);
        infoText.setVisible(true);
        nextAndSubmitConstraints();
        add(nb, constraints);
        nb.setVisible(false);
        updateTask();
        add(sb, constraints);
    }

    public void setNextListener(ActionListener newAction) {
        nb.addActionListener(newAction);
    }
    public void setSubmitListener(ActionListener newAction) {

        sb.addActionListener(newAction);
    }


    private void generalConstraints() {
        constraints.insets = new Insets(50, 100, 50, 100);
    }
    private void titleConstraints() {
        constraints.gridx = 1;
        constraints.gridy = 0;
    }

    private void nextAndSubmitConstraints() {
        constraints.gridx = 1;
        constraints.gridy = 3;
    }

    private void wordConstraints() {
        constraints.gridy = 1;
        constraints.gridx = 0;
    }

    private void answerFieldConstraints() {
        constraints.gridy = 1;
        constraints.gridx = 2;
    }
    private void setAfterSubmitTextConstraints() {
        constraints.gridy = 2;
        constraints.gridx = 1;
    }
    public String getAnswer() {
        return answerField.getText();
    }
    private void updateTask() {
        if (wit.hasNext()) {
            Word word = wit.next();
            solution = word.getHungarian();
            this.word.setText(word.getGerman());
        }
    }
    public void setWord(String text) {
        word.setText(text);
    }
    public void setInfoText(String text) {
        infoText.setText(text);
    }
    public void clearAnswerField() {
        answerField.setText("");
    }
    public void setNextVisible(boolean isVisible) {
        nb.setVisible(isVisible);
    }

    public void setSubmitVisible(boolean isVisible) {
        sb.setVisible(isVisible);
    }

    public void setBackgroundOnMistake() {
        setBackground(mistakeColor);
    }

    public void setBackgroundOnCorrectAnswer() {
        setBackground(correctAnswerColor);
    }

    public void setBaseColor() {
        setBackground(getBaseColor());
    }
}

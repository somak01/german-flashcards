package org.example.GUI;

import org.example.DB.WordSet;
import org.example.MODEL.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class GameMenu extends Menu{
    private final JLabel afterSubmitText = new JLabel("Translate the word");
    private final JTextField answerField = new JTextField();
    private final JLabel wordToBeTranslated = new JLabel();
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
        configureListeners();
        generaltConstraints();
        titleConstraints();
        add(title,constraints);
        wordToBeTranslatedConstraints();
        add(wordToBeTranslated, constraints);
        answerFieldConstraints();
        answerField.setMinimumSize(new Dimension(100, 50));
        answerField.setPreferredSize(new Dimension(100, 50));
        add(answerField, constraints);
        setAfterSubmitTextConstraints();
        add(afterSubmitText, constraints);
        afterSubmitText.setVisible(true);
        nextAndSubmitConstraints();
        add(nb, constraints);

        nb.setVisible(false);
        updateTask();
        add(sb, constraints);
    }

    private void setNextListener(ActionListener newAction) {
        setActionToButton(newAction, nb);
    }
    private void setSubmitListener(ActionListener newAction) {
        setActionToButton(newAction, sb);
    }

    private void configureListeners() {
        setNextListener(e -> {
            nb.setVisible(false);
            sb.setVisible(true);
            updateTask();
            clearAnswerField();
            afterSubmitText.setText("Translate the word");
        });
        setSubmitListener( e -> {
            sb.setVisible(false);
            nb.setVisible(true);
            if (getAnswer().equals(solution)) {
                setBackground(correctAnswerColor);
                afterSubmitText.setText("Correct!");
            } else {
                setBackground(mistakeColor);
                afterSubmitText.setText("The answer is: " + solution);
            }
         }
        );
    }
    private void generaltConstraints() {
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

    private void wordToBeTranslatedConstraints() {
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
    private String getAnswer() {
        return answerField.getText();
    }
    private void updateTask() {
        if (wit.hasNext()) {
            Word word = wit.next();
            solution = word.getHungarian();
            wordToBeTranslated.setText(word.getGerman());
        }
    }
    private void clearAnswerField() {
        answerField.setText("");
    }

}

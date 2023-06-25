package com.example.ignatdemon;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.Objects;

public class HelpController {
    @FXML
    private TextField Answer;
    @FXML
    private Button Button;
    @FXML
    private Button LastChance;

    @FXML
    private Text QuestionText;

    @FXML
    private Text HelpText;

    @FXML
    private TextField Textt;
    @FXML
    void click() {
        Button.setOnAction(event -> {
            String login = Textt.getText();
            User user = new User(login);
            String[][] users = new String[100][9];
            try {
                users = user.AllUsers();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] pureUser = user.HelpMe(login, users);
            if (pureUser[0] == null) {
                Textt.setVisible(false);
                Button.setVisible(false);
                HelpText.setText("ГГ, телефон админа +79877185100");

            }
            else {
                HelpText.setVisible(false);
                Textt.setVisible(false);
                Button.setVisible(false);
                QuestionText.setText(pureUser[4]);
                QuestionText.setVisible(true);
                LastChance.setVisible(true);
                Answer.setVisible(true);

            }
        });

    }
    @FXML
    void Last() {
        LastChance.setOnAction(event -> {
            String ans = Answer.getText();
            String login = Textt.getText();
            User user = new User(login);
            String[][] users = new String[100][9];
            try {
                users = user.AllUsers();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] pureUser = user.HelpMe(login, users);
            if (Objects.equals(pureUser[5], ans)) {
                QuestionText.setText("Ваш пароль: " + pureUser[1] + "\n Не забывайте его!");
                Answer.setVisible(false);
                LastChance.setVisible(false);
            }
            else {
                QuestionText.setText("ГГ, телефон админа +79877185100");
                Answer.setVisible(false);
                LastChance.setVisible(false);
            }

        });
    }

}

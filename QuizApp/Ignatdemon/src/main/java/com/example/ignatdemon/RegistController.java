package com.example.ignatdemon;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField Answer;

    @FXML
    private TextField Group;

    @FXML
    private TextField Login;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password;

    @FXML
    private TextField Question;

    @FXML
    private Button Registrate;

    @FXML
    void regist() {
        Registrate.setOnAction(event ->{
            String login = Login.getText();
            String password = Password.getText();
            String name = Name.getText();
            String group = Group.getText();
            String question = Question.getText();
            String ans = Answer.getText();
            User user = new User(login);
            try {
                user.CreateUser(login, password, name, group, question, ans);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

            stage.show();

        });
    }

}

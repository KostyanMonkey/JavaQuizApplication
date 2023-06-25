package com.example.ignatdemon;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddQuestion {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text Avg;

    @FXML
    private TextField First;

    @FXML
    private TextField Fourth;

    @FXML
    private TextField Group;

    @FXML
    private Text Login;

    @FXML
    private Text Name;

    @FXML
    private TextField Question;

    @FXML
    private Button SaveQuestion;

    @FXML
    private TextField Second;

    @FXML
    private Button TestStart;

    @FXML
    private TextField Third;

    @FXML
    void Add() {
        SaveQuestion.setOnAction(event -> {
            String group = Group.getText();
            String question = Question.getText();
            String first = First.getText();
            String second = Second.getText();
            String third = Third.getText();
            String fourth = Fourth.getText();

            String fin = question + "-" + first + "-" + second + "-" + third + "-" + fourth + "\n";

            File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/questions/group" + group + ".txt");
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    void switchToTestScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    void switchToUserScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userscene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToThemeTest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ThemeTest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

}

package com.example.ignatdemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThemeTestController {

    @FXML
    private Button ButtonAnswer;

    @FXML
    private RadioButton FirstAnswer;

    @FXML
    private RadioButton FourthAnswer;

    @FXML
    private Text QuestionText;

    @FXML
    private RadioButton SecondAnswer;

    @FXML
    private Button Start1;

    @FXML
    private Button Start2;

    @FXML
    private Button Start3;

    @FXML
    private Button Start4;

    @FXML
    private Button Start5;

    @FXML
    private Button TestStart;

    @FXML
    private RadioButton ThirdAnswer;

    @FXML
    private ToggleGroup answers;

    int ii = 0;

    int n = 0;


    @FXML
    Integer StartFive() {
        Start5.setOnAction(event -> {
            TakeQuest test = new TakeQuest(5);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(5);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(q[0][0]);
            Start1.setVisible(false);
            Start2.setVisible(false);
            Start3.setVisible(false);
            Start4.setVisible(false);
            Start5.setVisible(false);
            FirstAnswer.setVisible(true);
            SecondAnswer.setVisible(true);
            ThirdAnswer.setVisible(true);
            FourthAnswer.setVisible(true);

            ButtonAnswer.setVisible(true);
            QuestionText.setText(q[ii][0]);
            String[] answers1 = new String[4];
            for (int i = 0; i < 4; i++) {
                answers1[i] = q[ii][i + 1];
            }
            List<String> stringList = Arrays.asList(answers1);
            Collections.shuffle(stringList);

            FirstAnswer.setText(stringList.get(0));
            SecondAnswer.setText(stringList.get(1));
            ThirdAnswer.setText(stringList.get(2));
            FourthAnswer.setText(stringList.get(3));



        });
        return n = 5;
    }


    @FXML
    Integer StartFourth() {
        Start4.setOnAction(event -> {
            TakeQuest test = new TakeQuest(4);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(4);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(q[0][0]);
            Start1.setVisible(false);
            Start2.setVisible(false);
            Start3.setVisible(false);
            Start4.setVisible(false);
            Start5.setVisible(false);
            FirstAnswer.setVisible(true);
            SecondAnswer.setVisible(true);
            ThirdAnswer.setVisible(true);
            FourthAnswer.setVisible(true);

            ButtonAnswer.setVisible(true);
            QuestionText.setText(q[ii][0]);
            String[] answers1 = new String[4];
            for (int i = 0; i < 4; i++) {
                answers1[i] = q[ii][i + 1];
            }
            List<String> stringList = Arrays.asList(answers1);
            Collections.shuffle(stringList);

            FirstAnswer.setText(stringList.get(0));
            SecondAnswer.setText(stringList.get(1));
            ThirdAnswer.setText(stringList.get(2));
            FourthAnswer.setText(stringList.get(3));



        });
        return n = 4;
    }




    @FXML
    Integer StartSecond() {
        Start2.setOnAction(event -> {
            TakeQuest test = new TakeQuest(2);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(q[0][0]);
            Start1.setVisible(false);
            Start2.setVisible(false);
            Start3.setVisible(false);
            Start4.setVisible(false);
            Start5.setVisible(false);
            FirstAnswer.setVisible(true);
            SecondAnswer.setVisible(true);
            ThirdAnswer.setVisible(true);
            FourthAnswer.setVisible(true);

            ButtonAnswer.setVisible(true);
            QuestionText.setText(q[ii][0]);
            String[] answers1 = new String[4];
            for (int i = 0; i < 4; i++) {
                answers1[i] = q[ii][i + 1];
            }
            List<String> stringList = Arrays.asList(answers1);
            Collections.shuffle(stringList);

            FirstAnswer.setText(stringList.get(0));
            SecondAnswer.setText(stringList.get(1));
            ThirdAnswer.setText(stringList.get(2));
            FourthAnswer.setText(stringList.get(3));



        });
        return n = 2;
    }



    @FXML
    Integer StartThird() {
        Start3.setOnAction(event -> {
            TakeQuest test = new TakeQuest(3);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(3);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(q[0][0]);
            Start1.setVisible(false);
            Start2.setVisible(false);
            Start3.setVisible(false);
            Start4.setVisible(false);
            Start5.setVisible(false);
            FirstAnswer.setVisible(true);
            SecondAnswer.setVisible(true);
            ThirdAnswer.setVisible(true);
            FourthAnswer.setVisible(true);

            ButtonAnswer.setVisible(true);
            QuestionText.setText(q[ii][0]);
            String[] answers1 = new String[4];
            for (int i = 0; i < 4; i++) {
                answers1[i] = q[ii][i + 1];
            }
            List<String> stringList = Arrays.asList(answers1);
            Collections.shuffle(stringList);

            FirstAnswer.setText(stringList.get(0));
            SecondAnswer.setText(stringList.get(1));
            ThirdAnswer.setText(stringList.get(2));
            FourthAnswer.setText(stringList.get(3));



        });
        return n = 3;
    }



    @FXML
    Integer StartFirst() {
        Start1.setOnAction(event -> {
            TakeQuest test = new TakeQuest(1);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(q[0][0]);
            Start1.setVisible(false);
            Start2.setVisible(false);
            Start3.setVisible(false);
            Start4.setVisible(false);
            Start5.setVisible(false);
            FirstAnswer.setVisible(true);
            SecondAnswer.setVisible(true);
            ThirdAnswer.setVisible(true);
            FourthAnswer.setVisible(true);

            ButtonAnswer.setVisible(true);
            QuestionText.setText(q[ii][0]);
            String[] answers1 = new String[4];
            for (int i = 0; i < 4; i++) {
                answers1[i] = q[ii][i + 1];
            }
            List<String> stringList = Arrays.asList(answers1);
            Collections.shuffle(stringList);

            FirstAnswer.setText(stringList.get(0));
            SecondAnswer.setText(stringList.get(1));
            ThirdAnswer.setText(stringList.get(2));
            FourthAnswer.setText(stringList.get(3));



        });
        return n = 1;
    }
    TakeQuest c = new TakeQuest(2);
    int num = 0;


    @FXML
    void switchToThemeTest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ThemeTest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
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
    void Test() {
        ButtonAnswer.setOnAction(event -> {
            TakeQuest test = new TakeQuest(n);
            String[][] q = new String[10][5];
            try {
                q = test.TestTheme(n);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            RadioButton selectRadio = (RadioButton) answers.getSelectedToggle();
            if (selectRadio != null) {
                String correct = c.CorrectAns(q[ii]);
                String toggleGroupValue = selectRadio.getText();
                if (Objects.equals(toggleGroupValue, correct)){
                    ii++;
                    num++;
                }
                else {
                    System.out.println("Не верный ответ");
                    ii++;
                }


            }
            if (ii < 10){
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(q[ii][i] + " ");
//                }
//                System.out.println();
//                System.out.println();

                QuestionText.setText(q[ii][0]);
                String[] answers1 = new String[4];
                for (int i = 0; i < 4; i++) {
                    answers1[i] = q[ii][i + 1];
                }
                List<String> stringList = Arrays.asList(answers1);
                Collections.shuffle(stringList);

                FirstAnswer.setText(stringList.get(0));
                SecondAnswer.setText(stringList.get(1));
                ThirdAnswer.setText(stringList.get(2));
                FourthAnswer.setText(stringList.get(3));

                selectRadio.setSelected(false);
            }
            else {
                FirstAnswer.setVisible(false);
                SecondAnswer.setVisible(false);
                ThirdAnswer.setVisible(false);
                FourthAnswer.setVisible(false);

                ButtonAnswer.setVisible(false);
                selectRadio.setSelected(false);

                QuestionText.setText("Правильно " + num + " из 10");
            }

        });
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void switchToUserScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userscene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

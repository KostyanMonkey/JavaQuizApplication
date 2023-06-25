package com.example.ignatdemon;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.Scanner;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;


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
    private RadioButton ThirdAnswer;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Button Start;

    public HelloController() throws FileNotFoundException {
    }



    public void switchToUserScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userscene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private int nowQuestion = 0, correctAnswers;
    int ii = 0, n = 1;

    String[][] q;

    TakeQuest huy = new TakeQuest(1);
    String[][] q1 = huy.ReadFIle(1);
    String[][] q2 = huy.ReadFIle(2);
    String[][] q3 = huy.ReadFIle(3);
    String[][] q4 = huy.ReadFIle(4);
    String[][] q5 = huy.ReadFIle(5);
    TakeQuest c = new TakeQuest(2);

    public void switchToTestScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    public void StartTest() {



        FirstAnswer.setVisible(true);
        SecondAnswer.setVisible(true);
        ThirdAnswer.setVisible(true);
        FourthAnswer.setVisible(true);

        ButtonAnswer.setVisible(true);


        QuestionText.setText(q1[ii][0]);
        String[] answers1 = new String[4];
        for (int i = 0; i < 4; i++) {
            answers1[i] = q1[ii][i + 1];
        }
        List<String> stringList = Arrays.asList(answers1);
        Collections.shuffle(stringList);

        FirstAnswer.setText(stringList.get(0));
        SecondAnswer.setText(stringList.get(1));
        ThirdAnswer.setText(stringList.get(2));
        FourthAnswer.setText(stringList.get(3));
        n = 1;
        Start.setVisible(false);


    }



    int b = n;

    @FXML
    void switchToThemeTest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ThemeTest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void initialize() throws FileNotFoundException {

        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/UserNow.txt");
        Scanner s = new Scanner(file);
        String line = s.nextLine();
        String[] user = line.split("-");

        QuestionText.setText("У вас осталось " + user[8] + " попыток (-ки)");
        if (Objects.equals(user[8], "0")) {
            Start.setVisible(false);
        }

        ButtonAnswer.setOnAction(event -> {

            if (b != n) {
                ii = 0;
                b = n;
            }

            if (b == 1) {
                q = q1;
            } else if (b == 2) {
                q = q2;
            } else if (b == 3) {
                q = q3;
            } else if (b == 4) {
                q = q4;
            } else if (b==5) {
                q = q5;
            }
//            for (int i = 0; i < 5; i++) {
//                System.out.print(q[ii][i] + " ");
//            }
            RadioButton selectRadio = (RadioButton) answers.getSelectedToggle();
            if (selectRadio != null) {
                String correct = c.CorrectAns(q[ii]);
//                System.out.println(correct);
                String toggleGroupValue = selectRadio.getText();
//                System.out.println(toggleGroupValue + " " +  correct);

                if (Objects.equals(toggleGroupValue, correct)) {
                    System.out.println("Верный ответ");
                    if (ii == 0){
                        correctAnswers+=2;
                    }
                    else {
                        correctAnswers += 1;
                    }

                    n++;

                } else {
                    System.out.println("Не верный ответ");
                    ii++;
                }
            }
            if (ii > 1) {
                n++;
                ii = 0;
            }

            if (n != 6) {

                if (b != n) {
                    ii = 0;
                    b = n;
                }

                if (b == 1) {
                    q = q1;
                } else if (b == 2) {
                    q = q2;
                } else if (b == 3) {
                    q = q3;
                } else if (b == 4) {
                    q = q4;
                } else if (b == 5) {
                    q = q5;
                }

                for (int i = 0; i < 5; i++) {
                    System.out.print(q[ii][i] + " ");
                }
                System.out.println();
                System.out.println();

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

            } else {
                FirstAnswer.setVisible(false);
                SecondAnswer.setVisible(false);
                ThirdAnswer.setVisible(false);
                FourthAnswer.setVisible(false);
                ButtonAnswer.setVisible(false);
//                Start.setText("Пройти заново");
//                Start.setVisible(true);
                selectRadio.setSelected(false);

                QuestionText.setText("Правильно " + correctAnswers + " из 10");
                int alfa = Integer.valueOf(user[8]) - 1;
                user[8] = Integer.toString(alfa);
                User log = new User(user[0]);
                String[][] allLog = new String[100][9];
                try {
                    allLog = log.AllUsers();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                for (int l = 0; l < 100; l++) {
                    if(Objects.equals(allLog[l][0], user[0])){
                        allLog[l][8] = user[8];
                        Double hu = Double.valueOf(correctAnswers);
                        Double cc = hu/3;
                        Double krrr = Double.parseDouble(allLog[l][7]) + cc;
                        String alll = Double.toString(krrr) + "0000";




                        allLog[l][7] = alll.substring(0, 4);
                        user[7] = alll.substring(0, 4);
                    }
                }
                String fileName = "C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt";

                try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileName),
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String fileNam = "C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/UserNow.txt";

                try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileNam),
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                } catch (IOException e) {
                    e.printStackTrace();
                }

                File fille = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt");
                for (int ll = 0; ll < 100; ll++){
                    if (allLog[ll][0] != null) {
                        String t = allLog[ll][0] + "-" + allLog[ll][1] + "-" +allLog[ll][2] + "-" +allLog[ll][3] + "-" +allLog[ll][4] + "-" +allLog[ll][5] + "-" +allLog[ll][6] + "-" +allLog[ll][7] + "-" +allLog[ll][8] + "\n";
                        try (FileWriter writer = new FileWriter(fille, true)) {
                            writer.write(t);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                String t = user[0] + "-" + user[1] + "-" + user[2] + "-" + user[3] + "-" + user[4] + "-" + user[5] + "-" + user[6] + "-" + user[7] + "-" + user[8] + "\n";
                File fillle = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/UserNow.txt");
                try (FileWriter writer = new FileWriter(fillle, true)) {
                    writer.write(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        });
    }


}

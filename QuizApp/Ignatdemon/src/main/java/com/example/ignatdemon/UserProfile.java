package com.example.ignatdemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.Scanner;

public class UserProfile {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button AddBtt;


    @FXML
    private Text Avg;


    @FXML
    private Text Login;

    @FXML
    private TextField WhoBlock;

    @FXML
    private TextField WhoMakeAdm;

    @FXML
    private Text group;
    @FXML
    private Button MakeAdmin;

    @FXML
    private Text MakeAdminText;

    @FXML
    private Text BlockText;

    @FXML
    private Button BlockUser;

    @FXML
    private Text Name;



    @FXML
    private Button TestStart;

    @FXML
    void initialize() throws FileNotFoundException {

        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/UserNow.txt");
        Scanner s = new Scanner(file);
        String line = s.nextLine();
        String[] user = line.split("-");
        Login.setText(user[0]);
        Name.setText(user[2]);
        Avg.setText(user[7]);
        group.setText(user[3]);

        if (Objects.equals(user[6], "admin")) {
            AddBtt.setVisible(true);
            MakeAdmin.setVisible(true);
            WhoMakeAdm.setVisible(true);
            MakeAdminText.setVisible(true);
            BlockUser.setVisible(true);
            BlockText.setVisible(true);
            WhoBlock.setVisible(true);

        }
        else {
            AddBtt.setVisible(false);
            MakeAdmin.setVisible(false);
            WhoMakeAdm.setVisible(false);
            MakeAdminText.setVisible(false);
            BlockUser.setVisible(false);
            BlockText.setVisible(false);
            WhoBlock.setVisible(false);
        }
    }

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
    void Block() {
        BlockUser.setOnAction(event ->{
            String login = WhoBlock.getText();
            login += "\n";
            String fileName = "C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/BlockUsers.txt";
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(login);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }
    @FXML
    void makeAdmin() {

        MakeAdmin.setOnAction(event -> {
            String login = WhoMakeAdm.getText();
            User us = new User(login);
            String[][] users = new String[50][9];
            try {
                users = us.AllUsers();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 50; i++) {
                if(Objects.equals(login, users[i][0])){
                    users[i][6] = "admin";
                }
            }
            String fileName = "C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt";

            try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileName),
                    StandardOpenOption.TRUNCATE_EXISTING)) {
            } catch (IOException e) {
                e.printStackTrace();
            }
            File fille = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt");
            for (int ll = 0; ll < 100; ll++){
                if (users[ll][0] != null) {
                    String t = users[ll][0] + "-" + users[ll][1] + "-" +users[ll][2] + "-" +users[ll][3] + "-" +users[ll][4] + "-" +users[ll][5] + "-" +users[ll][6] + "-" +users[ll][7] + "-" +users[ll][8] + "\n";
                    try (FileWriter writer = new FileWriter(fille, true)) {
                        writer.write(t);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    @FXML
    void switchToAddScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AddQuestion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    void switchToUserScene(ActionEvent event) {

    }

}

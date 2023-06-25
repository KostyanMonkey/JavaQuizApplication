package com.example.ignatdemon;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UserInController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField Login;

    @FXML
    private TextField Password;

    @FXML
    private Button QuestionIn;

    @FXML
    private Button Registration;

    @FXML
    private Text log;

    @FXML
    private Text pas;

    @FXML
    private Button UserIn;
    @FXML
    private Text Text1;

    int tries = 3;

    @FXML
    void LogInn() {
        UserIn.setOnAction(event -> {
            String login = Login.getText();
            String password = Password.getText();
            User user = new User(login);
            String[][] users = new String[100][9];
            try {
                users = user.AllUsers();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            File huy = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/BlockUsers.txt");
            Scanner s;
            try {
                s = new Scanner(huy);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] blockUsers = new String[50];
            int i = 0;
            while (s.hasNextLine()){
                String line = s.nextLine();
                blockUsers[i] = line;
                i++;
            }
            for (int j = 0; j<50; j++){
                if (Objects.equals(blockUsers[j], login)){
                    Login.setVisible(false);
                    Password.setVisible(false);
                    UserIn.setVisible(false);
                    Registration.setVisible(false);
                    QuestionIn.setVisible(false);
                    log.setVisible(false);
                    pas.setVisible(false);
                    Text1.setText("Вы заблокированы");
                    password = "аозпопйжопфпофжпфлпуплфтйпхфмопфхффо";
                }
            }



            if (user.UserIn(login, password, users)) {



                String[] test = user.HelpMe(login, users);
                String t = test[0] + "-" + test[1] + "-" + test[2] + "-" + test[3] + "-" + test[4] + "-" + test[5] + "-" + test[6] + "-" + test[7] + "-" + test[8];
                File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/UserNow.txt");
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    root = FXMLLoader.load(getClass().getResource("userscene.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                tries--;
            }
            if (tries < 0) {
                System.out.println("Block User");
                login += "\n";
                String fileName = "C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/BlockUsers.txt";
                try (FileWriter writer = new FileWriter(fileName, true)) {
                    writer.write(login);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        });
    }

    @FXML
    void OnRegist() {
        Registration.setOnAction(event -> {
            try {
                root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
    }
    @FXML
    void help() {
        QuestionIn.setOnAction(event -> {
            try {
                root = FXMLLoader.load(getClass().getResource("Help.fxml"));
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

package com.example.ignatdemon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.Scanner;

public class User {

    String login, password, name, group, question, answer;

    public User(String login) {
        this.login = login;
    }

    public void CreateUser(String login, String password, String name, String group, String question, String answer) throws IOException {
        this.login = login;
        this.password = password;
        this.name = name;
        this.group = group;
        this.question = question;
        this.answer = answer;

        String text = login + "-" + password + "-" + name + "-" + group + "-" + question + "-" + answer + "-user-0-3\n";
        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt");
        try (FileWriter writer = new FileWriter(file, true)) {

            writer.write(text);



        }
        catch (IOException e) {
            System.out.println("Ошибка");
        }

    }

    public String[][] AllUsers() throws FileNotFoundException {
        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/Users/Users.txt");
        Scanner s = new Scanner(file);
        String[][] users = new String[100][9];
        int i = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String[] user = line.split("-");
            users[i] = user;
            i++;

        }
        return users;

    }

    public String[] HelpMe(String login, String[][] arr) {
        String[] user = new String[9];
        for(int i = 0; i < 100; i++) {
            if(Objects.equals(arr[i][0], login)){
                user = arr[i];
            }
        }
        return user;
    }

    public boolean UniqeUser(String login, String[][] arr) {
        for(int i = 0; i < 100; i++) {
            if(Objects.equals(arr[i][0], login)) {
                return false;
            }
        }
        return true;
    }



    public boolean UserIn(String login, String password, String[][] arr) {
        for(int i = 0; i < 100; i++) {
            if (Objects.equals(arr[i][0], login)) {
                System.out.println("good");
                if (Objects.equals(arr[i][1], password)) {
                    System.out.println("good");
                    return true;
                }

            }
        }
        return false;
    }
}

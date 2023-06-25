package com.example.ignatdemon;

public class UserInfo {

    private String login, password, name, group, question, answer, role, avgball, tries;

    public void setUserInfo(String login, String password, String name, String group, String question, String answer, String role, String avgball, String tries) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.group = question;
        this.answer = answer;
        this.role = role;
        this. avgball = avgball;
        this.tries = tries;

    }
    public void print() {
        System.out.println(login + " " + password + " " + name);
    }
}

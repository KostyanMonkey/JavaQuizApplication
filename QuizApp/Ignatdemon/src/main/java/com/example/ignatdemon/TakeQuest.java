package com.example.ignatdemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TakeQuest {

    int n;

    public TakeQuest(int n) {
        this.n = n;
    }

    public String[][] TestTheme(int n) throws FileNotFoundException {
        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/questions/group" + Integer.toString(n) + ".txt");
        Scanner s = new Scanner(file);
        String[][] arr = new String[20][5];
        int i = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] questAns = line.split("-");
            arr[i] = questAns;
            i++;
        }

        return arr;
    }

    public String[][] ReadFIle(int n) throws FileNotFoundException {
        File file = new File("C:/Users/razum/OneDrive/Рабочий стол/ебать в попку/Ignatdemon/questions/group" + Integer.toString(n) + ".txt");
        Scanner s = new Scanner(file);
        String[][] arr = new String[100][5];
        int i = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] questAns = line.split("-");
            arr[i] = questAns;
            i++;
        }
        String[][] fin = new String[2][5];
        int m = (int) (Math.random() * i);
        fin[0] = arr[m];

        int k = (int) (Math.random() * i);
        while (m == k) {
            k = (int) (Math.random() * i);
        }
        fin[1] = arr[k];


        return fin;
    }

    public String CorrectAns(String[] arr) {
        return arr[arr.length - 1];
    }
}

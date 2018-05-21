package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        reader.close();
*/
        String filename1 = "d:/inf.txt";
        String filename2 = "d:/inf2.txt";

        FileReader fr1 = new FileReader(filename1);
        BufferedReader buffReader1 = new BufferedReader(fr1);
        String line1;
        List<String> lines1 = new ArrayList<>();
        while ((line1 = buffReader1.readLine()) != null) {
            lines1.add(line1);
        }
        buffReader1.close();


        FileReader fr2 = new FileReader(filename2);
        BufferedReader buffReader2 = new BufferedReader(fr2);
        String line2;
        List<String> lines2 = new ArrayList<>();
        while ((line2 = buffReader2.readLine()) != null) {
            lines2.add(line2);
        }
        buffReader2.close();



        for (int i = 0; i < lines1.size(); i++) {
        try {
            if (lines1.get(i).equals(lines2.get(0))) {
                lines.add(new LineItem(Type.SAME, lines1.get(i)));
                lines2.remove(lines2.get(0));

            } else if (lines1.get(i).equals(lines2.get(1))) {
                lines.add(new LineItem(Type.ADDED, lines1.get(1)));
                i--;
                lines2.remove(lines2.get(0));

            } else {
                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));

            }
        }catch ( IndexOutOfBoundsException e){
            lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
        }

        }


        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

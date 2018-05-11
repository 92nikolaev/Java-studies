package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename1 = scanner.nextLine();
        String filename2 = scanner.nextLine();
        scanner.close();

        File file1 = new File(filename1);
        File file2 = new File(filename2);

        byte[] bytes1=null;
        byte[] bytes2=null;
        int count1=0;
        int count2=0;

        FileInputStream fis1 = new FileInputStream(file1);
        while (fis1.available() > 0) {
            bytes1 = new byte[fis1.available()];
          count1 = fis1.read(bytes1);

        }
        fis1.close();

        FileInputStream fis2 = new FileInputStream(file2);
        FileOutputStream fos1 = new FileOutputStream(file1);


        while (fis2.available() > 0) {
            bytes2 = new byte[fis2.available()];
            count2 = fis2.read(bytes2);
            fos1.write(bytes2,0,count2);

        }
        fis2.close();
        fos1.close();


        FileOutputStream fos2 = new FileOutputStream(file1, true);

        fos2.write(bytes1);
        fos2.close();


    }
}


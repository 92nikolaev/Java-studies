package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        List<String> surnames = new ArrayList<>();
        List<Double> salaries = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            surnames.add(line.split(" ")[0]);
            salaries.add(Double.parseDouble(line.split(" ")[1]));
        }
        bufferedReader.close();

        Map<String, Double> values = new TreeMap<>();

        for (int i = 0; i < surnames.size(); i++) {
            if (Collections.frequency(surnames, surnames.get(i)) == 1) {
                values.put(surnames.get(i), salaries.get(i));
            } else {
                for(int j=i+1; j<surnames.size();j++){
                    if(surnames.get(j).equals(surnames.get(i))){
                       values.put(surnames.get(i), salaries.get(i)+salaries.get(j));
                    }
                }
            }
        }
        for(Map.Entry<String,Double> entry : values.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            System.out.println(key + " " + value);
        }

    }
}

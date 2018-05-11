package com.javarush.task.task18.task1825;

import java.io.*;

import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        List<File> files = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) break;
            files.add(new File(fileName));
        }
        reader.close();

        sorterByExtension(files);
        System.out.println(files);
        File fileEnd = new File((files.get(0).getAbsolutePath()).split(".part")[0]);

        for(int i=0; i<files.size();i++){
            FileInputStream fis = new FileInputStream(files.get(i));
            byte[] bytes = null;
            int count1=0;
            while (fis.available() > 0) {
                bytes = new byte[fis.available()];
                count1 = fis.read(bytes);
            }
            fis.close();
            FileOutputStream fos2 = new FileOutputStream(fileEnd, true);
            fos2.write(bytes);
            fos2.close();
        }


    }

    public static ArrayList sorterByExtension(List<File> list){
            Collections.sort(list, new Sort());
            return (ArrayList) list;
    }

    public static int getExtension(File file){
        String filename=file.getName();
        return Integer.parseInt((filename.split("\\.(?=[^\\.]+$)")[1]).substring(4));
    }

    static class Sort implements Comparator<File>{

        @Override
        public int compare(File o1, File o2) {
            return getExtension(o1)-(getExtension(o2));
        }
    }
}

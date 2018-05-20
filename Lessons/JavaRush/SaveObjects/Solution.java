package com.javarush.task.task20.task2001;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args)  {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("D:/log.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov",new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = Human.load(inputStream);
            inputStream.close();
            outputStream.close();
            if(somePerson.equals(ivanov)) System.out.print("ok");
            else System.out.print("not ok");

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public static List<Asset> assets = new ArrayList<>();

        public Human() {

        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;


        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {

            outputStream.write((name+"\n").getBytes());
            if(assets.size()!=0) {
                for (Asset el : assets) {
                    outputStream.write(el.getName().getBytes());
                    outputStream.write(el.getPrice().getBytes());
                }
            }
        }

        public static Human load(InputStream inputStream) throws Exception {
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            Human vasya = new Human();


            while(inputStream.available()>0) {
                String result = s.hasNext() ? s.next() : "";
                String[] temp = result.split("\n");
                String name = temp[0];
                vasya.name = name;

                try{
                    for(int i=0; i<temp.length;i++) {
                        String assetName = temp[i].split(" ")[0];
                        Double assetValue = Double.parseDouble(temp[i].split(" ")[1]);
                        Asset assetI=new Asset(assetName, assetValue);
                        vasya.assets.add(assetI);
                    }
            }
                catch (ArrayIndexOutOfBoundsException e){
                    return vasya;
            }

            }
            return vasya;
        }
    }
}

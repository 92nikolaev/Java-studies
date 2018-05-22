package com.javarush.task.task20.task2002;



import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("2002____", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User vasya=new User();
            Date vasyaBD=new Date();
            vasyaBD.setTime(100000000);
            vasya.setBirthDate(vasyaBD);
            vasya.setCountry(User.Country.RUSSIA);
            vasya.setFirstName("Vasya");
            vasya.setLastName("Ivanov");
            vasya.setMale(true);
            javaRush.users.add(vasya);


            User petya=new User();
            Date petyaBD=new Date();
            petyaBD.setTime(300000000);
            petya.setBirthDate(petyaBD);
            petya.setCountry(User.Country.UKRAINE);
            petya.setFirstName("Petya");
            petya.setLastName("Petrov");
            petya.setMale(true);
            javaRush.users.add(petya);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //loadedObject.users.addAll()
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)) System.out.println("ok");
            else System.out.println("not ok");
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            try {
                for (int i = 0; i < users.size(); i++) {
                    outputStream.write((users.get(i).getFirstName() + "@").getBytes());
                    outputStream.write((users.get(i).getLastName() + "@").getBytes());
                    outputStream.write((users.get(i).getBirthDate().getTime() + "@").getBytes());
                    outputStream.write((users.get(i).isMale() + "@").getBytes());
                    outputStream.write((users.get(i).getCountry().getDisplayedName() + "\n").getBytes());
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public void load(InputStream inputStream) throws Exception {

            Scanner s = new Scanner(inputStream).useDelimiter("\\A");

            while(inputStream.available()>0) {
                String result = s.hasNext() ? s.next() : "";
                String[] temp = result.split("\n");

                try{
                    for(int i=0; i<temp.length;i++) {
                        User user=new User();
                        String firstName = temp[i].split("@")[0];
                        String secondName=temp[i].split("@")[1];
                        String bd=temp[i].split("@")[2];
                        Date bdD=new Date();
                        bdD.setTime(Long.parseLong(bd));
                        boolean isMale= Boolean.parseBoolean(temp[i].split("@")[3]);
                        String countryS=temp[i].split("@")[4];

                        switch (countryS){
                            case "Russia":  user.setCountry(User.Country.RUSSIA); break;
                            case "Ukraine": user.setCountry(User.Country.UKRAINE);break;
                                default: user.setCountry(User.Country.OTHER); break;
                        }
                        user.setMale(isMale);
                        user.setLastName(secondName);
                        user.setFirstName(firstName);
                        user.setBirthDate(bdD);
                        users.add(user);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

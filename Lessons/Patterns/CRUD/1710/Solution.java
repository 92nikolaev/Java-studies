package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formInp = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;

        if (args.length > 1) {
            int id = 0;
            try {
                id = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {}

        switch (args[0]){
            case "-c":
                date = formInp.parse(args[3]);
                if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], date));
                if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], date));
                System.out.println(allPeople.size() - 1);
                break;

            case "-u":
                allPeople.get(id).setName(args[2]);
                if (args[3].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                if (args[3].equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);
                date = formInp.parse(args[4]);
                allPeople.get(id).setBirthDay(date);
                break;

            case "-d":
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                break;

            case "-i":
                Person person = allPeople.get(id);
                String name = person.getName();
                String bd = formOut.format(person.getBirthDay());
                String sex=null;
                switch (person.getSex()){
                    case FEMALE:sex="ж"; break;
                    case MALE: sex ="м"; break;
                    default: sex=null; break;
                }
                System.out.println(name+" "+sex+" "+bd);
                break;
            }
        }



    }


}

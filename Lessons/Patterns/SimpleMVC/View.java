package by.lesson13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class View {

    public final static int READ_COMMAND = 1;
    public final static int SAVE_COMMAND = 2;
    public final static int DELETE_COMMAND = 3;
    public final static int EDIT_COMMAND = 4;
    public final static int EXIT_COMMAND = -1;

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public boolean readFileName(Model model) throws FileNotFoundException {
        System.out.println("Please enter file name:");
        String fileName = scanner.nextLine();

        if ("".equals(fileName.trim())) {
            return false;
        }

        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException();

        model.setFileName(file.getName());
        model.setPath(file.getPath());
        return true;
    }

    public int printMainMenu() {
        System.out.println("Please select operation:");
        System.out.println("(1) read file;");
        System.out.println("(2) save file;");
        System.out.println("(3) delete file;");
        System.out.println("(4) edit file");
        System.out.println("(exit) for exit");
        String s = scanner.nextLine();

        switch (s.trim()) {
            case "1": {

                return READ_COMMAND;

            }
            case "2": {

                return SAVE_COMMAND;
            }
            case "3": {

                return DELETE_COMMAND;
            }
            case "4": {

                return EDIT_COMMAND;
            }
            case "exit": {

                return EXIT_COMMAND;
            }
            default: {

                return printMainMenu();
            }
        }

    }

    public boolean saveFile(Model model) {
        if (model.isChanged()) {
            System.out.println("Saving file: "
                    + File.separator + model.getPath());
        } else {
            System.out.println("File is not changed");
            return false;
        }
        return true;
    }

    public void printSaveResult(boolean res) {
        if (res)
            System.out.println("Saved successfully");
        else
            System.out.println("Save error");
    }

    public boolean deleteFile(Model model) {
        System.out.println("Please confirm delete file: " +
                model.getPath() + " (Yes)/(No)");
        String s = scanner.nextLine();
        boolean res;
        if ("Yes".equalsIgnoreCase(s.trim())) {
            System.out.println("Delete confirmed");
            res = true;

        } else {
            System.out.println("Delete cancelled");
            res = false;

        }
        return res;
    }

    public void deleteEdit(Model model){
        System.out.println("Deleting file "+model.getPath());
        File file = new File(model.getPath());
        try {
            //TODO close all scanners!
            Files.deleteIfExists(file.toPath());
            printDeleteResult(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printDeleteResult(boolean res) {
        if (res)
            System.out.println("Delete successfully");
        else
            System.out.println("Delete error");
    }

    public void printProperties(Model model) {
        System.out.println("Properties: ");
        System.out.println(model.getProperties());
    }

    public void printEdit(Model model){
        System.out.println("You are editing file "+model.getPath());
        System.out.println("Enter key");
        String key=scanner.nextLine();
        System.out.println("Enter value");
        String value=scanner.nextLine();
        System.out.println("Key = "+key+ "; Value = "+value + "; Enter (yes) to confirm change");
        String yes=scanner.nextLine();
        if("yes".equalsIgnoreCase(yes)){
            model.setProperty(key, value);
            System.out.println("Successfully");
            scanner.close();
        }
        else {
            System.out.println("Cancelled");
            scanner.close();
        }

    }


}

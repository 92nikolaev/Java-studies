package by.lesson13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class Controller {

    View view;
    Model model;

    public Controller() {
        view = new View();
    }

    public void doAction() {
        int command = view.printMainMenu();
        try {
            if (command == View.EXIT_COMMAND) {
                System.exit(0);
            } else if (command == View.READ_COMMAND) {
                if (model == null) {
                    model = new Model();
                } else {
                    ;
                }  //Do something if model exists already
                view.readFileName(model);
                loadProperties(model);
                view.printProperties(model);

            } else if (command == View.SAVE_COMMAND) {
                if (view.saveFile(model)) {
                    saveProperties(model);
                    view.printSaveResult(saveProperties(model));
                }
            } else if (command == View.DELETE_COMMAND) {
                //Do delete
            } else if (command == View.EDIT_COMMAND) {
                view.printEdit(model);
                view.printProperties(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean saveProperties(Model model) {
        boolean res = true;
        Properties pro = model.getProperties();
        try (FileOutputStream fis = new FileOutputStream(model.getPath())) {
            pro.store(fis, "UPD" + LocalDate.now());
        } catch (IOException e) {
            res = false;
            e.printStackTrace();
        }
        return res;
    }

    private void loadProperties(Model model) {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(model.getPath()));
            model.setProperties(pro);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}

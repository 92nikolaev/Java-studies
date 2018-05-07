package by.it.academy.database;

import by.it.academy.model.UserData;

import java.util.List;

public interface UserDataDao {

    UserData createUserData(UserData userData);
    UserData readUserData(String loginName);
    UserData readUserData(int id);
    List<UserData> readAllUserData();
}

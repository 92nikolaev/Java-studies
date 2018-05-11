package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.UserData;


import java.util.List;

public interface UserDataDao {

    UserData createUserData(UserData userData);
    UserData readUserData(String loginName);
    UserData readUserData(int id);
    List<UserData> readAllUserData();
}

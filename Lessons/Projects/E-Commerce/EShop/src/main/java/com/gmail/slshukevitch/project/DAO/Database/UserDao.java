package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.User;

public interface UserDao {

    User createUser(User user);
    User readUser(String loginName);
    User readUser(int id);

}

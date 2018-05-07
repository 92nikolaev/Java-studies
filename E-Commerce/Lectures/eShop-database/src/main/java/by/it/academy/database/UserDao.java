package by.it.academy.database;

import by.it.academy.model.User;

public interface UserDao {

    User createUser(User user);
    User readUser(String loginName);
    User readUser(int id);

}

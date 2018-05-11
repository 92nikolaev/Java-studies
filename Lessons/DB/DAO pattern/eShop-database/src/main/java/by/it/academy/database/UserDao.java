package by.it.academy.database;

public interface UserDao {
    //CRUD
    User createUser(User user); //for new user without ID (aka primary key in our DB)
    //Get user, write to BD, return from BD

    User readUser(String userName);
    User readUser(int id);

}

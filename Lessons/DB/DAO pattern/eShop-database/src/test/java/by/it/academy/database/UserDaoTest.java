package by.it.academy.database;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserDaoTest {


    @Test
    public void testCreateUser() {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

    }

    @Test
    public void testReadUserByName() { //completed
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        assertNotNull(userDao.readUser("admin"));
        assertEquals(1, userDao.readUser("admin").getId());
    }

    @Test
    public void testReadUserbyId() {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
    }

}

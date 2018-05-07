package by.it.academy.database;

import by.it.academy.model.UserData;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserDataDaoTest {

    @Test
    public void testReadUserData(){
        UserDataDao userDataDao = DaoFactory.getInstance().getUseDataDao();
        assertNull(userDataDao.readUserData(null));
        assertNull(userDataDao.readUserData(""));
        UserData userData = userDataDao.readUserData("admin");
        assertNotNull(userData);
        assertEquals(userData.getPassword(), "password");

    }


}

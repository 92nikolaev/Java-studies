
import com.gmail.slshukevitch.project.DAO.Database.DaoFactory;
import com.gmail.slshukevitch.project.DAO.Database.UserDataDao;
import com.gmail.slshukevitch.project.DAO.Model.UserData;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
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

        UserData userData2 = userDataDao.readUserData("user3");
        assertNotNull(userData2);
        assertEquals(userData2.getPassword(), "password123");

    }


}

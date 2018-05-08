import com.gmail.slshukevitch.project.DAO.Database.DaoFactory;
import com.gmail.slshukevitch.project.DAO.Database.UserDao;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDaoTest {

    @Test
    public void testCreateUser() {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

    }

    @Test
    public void testReadUserByName() {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        assertNotNull(userDao.readUser("admin"));
        assertEquals(1, userDao.readUser("admin").getId());

    }

    @Test
    public void testReadUserbyId() {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
    }

}

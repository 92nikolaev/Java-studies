
import com.gmail.slshukevitch.project.DAO.Database.DaoFactory;
import com.gmail.slshukevitch.project.DAO.Database.ProductDao;
import com.gmail.slshukevitch.project.DAO.Model.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ProductDaoImplTest {
        @Test

    public void testAllProduct(){
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            List<Product> productList = productDao.readAllProduct();
            assertNotNull(productList);
            assertEquals(5,productList.size());
        }

}

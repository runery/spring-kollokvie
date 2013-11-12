package filmer.dao.annotation;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context-annotation.xml")
public class JdbcBetalingDaoTest {

    @Autowired
    private BetalingDao betalingDao;

    @Test
    public void testRegistrerBetaling() throws Exception {
        assertNotNull(betalingDao);
        betalingDao.registrerBetaling(40,1);
    }
}

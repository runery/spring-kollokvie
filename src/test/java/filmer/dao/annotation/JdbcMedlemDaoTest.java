package filmer.dao.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context-annotation.xml")
public class JdbcMedlemDaoTest {

    @Autowired
    private MedlemDao medlemDao;

    @Test
    public void testFinnNavnVedId() throws Exception {
        assertNotNull(medlemDao);
        String navn = medlemDao.finnNavnVedId(1);
        assertEquals("Janet Jones", navn);
    }

    @Test
        public void testFinnIdVedNavn() throws Exception {
        int id = medlemDao.finnIdVedNavn("Janet Jones");
        assertEquals(1,id);
    }

    @Test
    public void testFinnAlleMedlemmersNavn() throws Exception {
        assertNotNull(medlemDao);
        List<String> medlemmer = medlemDao.finnAlleMedlemmersNavn();
        assertTrue(medlemmer.size() > 0);

        for (String s: medlemmer) {
            System.out.println(s);

        }
    }
}

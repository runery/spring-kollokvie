package filmer.dao.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context-annotation.xml")
public class JdbcFilmDaoTest {

    @Autowired
    private FilmDao filmDao;

    @Test
    public void testFinnFilmVedId() throws Exception {
        assertNotNull(filmDao);

        String filmnavn = filmDao.finnFilmVedId(1L);

        assertEquals("Pirates of the Caribean 4", filmnavn);
    }
}

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
public class JdbcFilmLeieDaoTest {

    @Autowired
    private FilmLeieDao filmLeieDao;

    @Test
    public void testRegistrerLeie() throws Exception {
        assertNotNull(filmLeieDao);
        int idFilmleieReg;

        idFilmleieReg = filmLeieDao.registrerLeie(1,1);

        assertEquals(6, idFilmleieReg);
    }
}

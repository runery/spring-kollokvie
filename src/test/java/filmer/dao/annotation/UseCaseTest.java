package filmer.dao.annotation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context-annotation.xml")
public class UseCaseTest {

    @Autowired
    private BetalingDao betalingDao;
    @Autowired
    private FilmLeieDao filmLeieDao;

    @Test
    public void testLeiFilmOgTaBetalt() throws Exception {
        assertNotNull(betalingDao);
        assertNotNull(filmLeieDao);

        int leieId;
        boolean kjoepOk = false;
        leieId = filmLeieDao.registrerLeie(1,2);
        kjoepOk = betalingDao.registrerBetaling(40,leieId);
        assertTrue(kjoepOk);
    }
}

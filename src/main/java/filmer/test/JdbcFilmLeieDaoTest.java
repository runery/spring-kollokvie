package filmer.test;

import filmer.dao.annotation.FilmLeieDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcFilmLeieDaoTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        FilmLeieDao filmLeieDao = ctx.getBean("filmLeieDao", FilmLeieDao.class);

        filmLeieDao.registrerLeie(1, 1);
    }
}

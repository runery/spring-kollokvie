package filmer.test;

import filmer.dao.annotation.FilmDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class jdbcFilmDaoTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();

        FilmDao filmDao = ctx.getBean("filmDao", FilmDao.class);

        System.out.println("Navn på film med id 1 er: " + filmDao.finnFilmVedId(1L));
    }
}

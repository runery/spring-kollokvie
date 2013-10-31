package filmer.test;

import filmer.dao.FilmDao;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: rry
 * Date: 31.10.13
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class jdbcFilmDaoTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();

        FilmDao filmDao = ctx.getBean("filmDao", FilmDao.class);

        System.out.println("Navn på film med id 1 er: " + filmDao.finnFilmVedId(1L));
    }
}

package filmer.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: rry
 * Date: 31.10.13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class JdbcFilmDao implements FilmDao, InitializingBean {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("M� sette datasource p� FilmDao") ;
        }
    }

    @Override
    public String finnFilmVedId(Long id) {
        String filmNavn = jdbcTemplate.queryForObject("select title from movies where movie_id = ?", new Object[]{id}, String.class);
        return filmNavn;
    }
}

package filmer.dao;

import javax.sql.DataSource;

import filmer.dao.annotation.FilmDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcXmlFilmDao implements FilmDao, InitializingBean {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Må sette datasource på FilmDao") ;
        }
    }

    @Override
    public String finnFilmVedId(Long id) {
        String filmNavn = jdbcTemplate.queryForObject("select title from movies where movie_id = ?", new Object[]{id}, String.class);
        return filmNavn;
    }

    @Override
    public int finnFilmvedNavn(String navn) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

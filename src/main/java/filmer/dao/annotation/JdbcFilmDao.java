package filmer.dao.annotation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("filmDao")
public class JdbcFilmDao implements FilmDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public String finnFilmVedId(Long id) {
        String sql = "SELECT title FROM movies WHERE movie_id = :filmid";

        Map<String,Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("filmid", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public int finnFilmvedNavn(String navn) {
        String sql = "select movie_id from movies where title = :filmnavn";

        Map<String,Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("filmnavn", navn);

        return namedParameterJdbcTemplate.queryForInt(sql,namedParameters);
    }
}

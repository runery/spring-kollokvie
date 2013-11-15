package filmer.dao.annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import filmer.dao.annotation.util.MedlemMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository("medlemDao")
public class JdbcMedlemDao implements MedlemDao {

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
    public String finnNavnVedId(int medlemid) {
        String navn = jdbcTemplate.queryForObject("SELECT full_names FROM members WHERE membership_number = ?", new Object[]{medlemid}, String.class);;

        return navn;
    }

    @Override
    public int finnIdVedNavn(String navn) {
        String sql = "SELECT membership_number FROM members WHERE full_names = :medlemsnavn";

        //SqlParameterSource namedParameters = new MapSqlParameterSource("medlemsnavn", navn);
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("medlemsnavn", navn);

        return namedParameterJdbcTemplate.queryForInt(sql, namedParameters);
    }

    @Override
    public List<String> finnAlleMedlemmersNavn() {
        String sql = "select full_names from members";

        return jdbcTemplate.query(sql, new MedlemMapper());
    }

    //TODO: Lage en insert medlem metode som kun brukerjdbctemplate
}

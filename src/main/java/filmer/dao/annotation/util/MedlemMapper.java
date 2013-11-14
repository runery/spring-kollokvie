package filmer.dao.annotation.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MedlemMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet rs, int rownum) throws SQLException {
        String navn = new String();
        navn = rs.getString("full_names");
        return navn;
    }
}

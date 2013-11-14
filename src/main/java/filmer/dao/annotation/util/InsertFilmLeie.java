package filmer.dao.annotation.util;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertFilmLeie extends SqlUpdate {
    private  static final  String SQL_INSERT_FILMLEIE =
            "INSERT INTO movierentals (transaction_date, return_date, membership_number, movie_id, movie_returned) VALUES (:leiedato, " +
                    ":innleveringsdato, :medlemsnr, :filmid, :returnert)";

    public InsertFilmLeie(DataSource dataSource) {
        super(dataSource, SQL_INSERT_FILMLEIE);
        super.declareParameter(new SqlParameter("leiedato", Types.DATE));
        super.declareParameter(new SqlParameter("innleveringsdato", Types.DATE));
        super.declareParameter(new SqlParameter("medlemsnr", Types.INTEGER));
        super.declareParameter(new SqlParameter("filmid", Types.INTEGER));
        super.declareParameter(new SqlParameter("returnert", Types.INTEGER));
        super.setGeneratedKeysColumnNames(new String[]{"reference_number"});
        super.setReturnGeneratedKeys(true);
    }


}

package filmer.dao.annotation.util;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBetaling extends SqlUpdate{

    private  static final  String SQL_INSERT_BETALING =
            "INSERT INTO payments (reference_number, payment_date, description, amount_paid, external_reference_number) VALUES (:referanse_leie, " +
                    ":betalingsdato, :beskrivelse, :belop_betalt, :eksternt_referansenummer)";

    public InsertBetaling(DataSource dataSource) {
        super(dataSource, SQL_INSERT_BETALING);
        super.declareParameter(new SqlParameter("referanse_leie", Types.INTEGER));
        super.declareParameter(new SqlParameter("betalingsdato", Types.DATE));
        super.declareParameter(new SqlParameter("beskrivelse", Types.VARCHAR));
        super.declareParameter(new SqlParameter("belop_betalt", Types.FLOAT));
        super.declareParameter(new SqlParameter("eksternt_referansenummer", Types.INTEGER));
        super.setGeneratedKeysColumnNames(new String[]{"payment_id"});
        super.setReturnGeneratedKeys(true);
    }
}

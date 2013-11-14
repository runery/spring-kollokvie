package filmer.dao.annotation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import filmer.dao.annotation.util.InsertBetaling;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("betalingDao")
public class JdbcBetalingDao implements BetalingDao {
    private InsertBetaling insertBetaling;
    private DataSource dataSource;
    private Log log = LogFactory.getLog(JdbcBetalingDao.class);

    @Resource(name="dataSource" )
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        insertBetaling = new InsertBetaling(dataSource);
    }

    @Override
    public boolean registrerBetaling(int belop, int leieId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("referanse_leie", leieId);
        paramMap.put("betalingsdato", new Date());
        paramMap.put("beskrivelse", "En beskrivelse");
        paramMap.put("belop_betalt", belop);
        paramMap.put("eksternt_referansenummer", null);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertBetaling.updateByNamedParam(paramMap, keyHolder);
        log.info("Betaling registrert med id" + keyHolder.getKey().intValue());
        return true;
    }
}

package filmer.dao.annotation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("filmLeieDao")
public class JdbcFilmLeieDao implements FilmLeieDao {
    private InsertFilmLeie insertFilmLeie;
    private DataSource dataSource;
    private Log log = LogFactory.getLog(JdbcFilmLeieDao.class);

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        insertFilmLeie = new InsertFilmLeie(dataSource);
    }
    @Override
    public int registrerLeie(int medlemid, int filmid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("leiedato", new Date());
        paramMap.put("innleveringsdato", null);
        paramMap.put("medlemsnr", medlemid);
        paramMap.put("filmid", filmid);
        paramMap.put("returnert", 0);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertFilmLeie.updateByNamedParam(paramMap, keyHolder);
        log.info("Filmleie registrert med id" + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }
}

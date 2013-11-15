package filmer.dao.annotation;

public interface FilmLeieDao {
    int registrerLeie(int medlemid, int filmid);
    int finnAntallRaderILeie();
}

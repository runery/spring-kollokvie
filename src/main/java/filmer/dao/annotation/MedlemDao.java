package filmer.dao.annotation;

import java.util.List;

public interface MedlemDao {
    String finnNavnVedId(int medlemid);
    int finnIdVedNavn(String navn);
    List<String> finnAlleMedlemmersNavn();
}

package MMDataAccess.MMIDAO;

import java.util.List;
import java.sql.SQLException;


public interface MMIDAO<T> {
    void create(T entity) throws SQLException;
    List<T> readAll() throws SQLException;
    void update(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
}
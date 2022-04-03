package ex1;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public interface Repository<T> {
    void persist(T obj) throws ParseException, SQLException;
    void delete(T obj) throws SQLException;
    void update(T obj)  throws SQLException;
    void findPrimaryKey(Statement stm) throws SQLException;
}

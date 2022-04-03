package ex2;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public interface Operations<T> {
    void insert(T o) throws ParseException, SQLException;
    void update(T o) throws SQLException;
    void delete(T o) throws SQLException;
    void findByPrimaryKey(T o) throws SQLException;
    void findByForeignKey(T o) throws SQLException;
}

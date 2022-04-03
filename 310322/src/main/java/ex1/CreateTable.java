package ex1;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends Thread {
    public void run(Statement stm) throws SQLException {
        String sqlTable = "CREATE TABLE IF NOT EXISTS JOB.Employee " +
                "(ID INT not NULL, " +
                " Name VARCHAR(255), " +
                " LastName VARCHAR(255), " +
                " PRIMARY KEY(ID))";
        stm.executeUpdate(sqlTable);
    }
}

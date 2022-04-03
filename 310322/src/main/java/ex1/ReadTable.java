package ex1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadTable extends Thread {
    public void run(Statement stm) throws SQLException {
        ResultSet resSet = stm.executeQuery("SELECT * FROM Employee;");
        ResultSetMetaData md = resSet.getMetaData();

        System.out.println("ID Name LastName");
        while (resSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.print(resSet.getString(i) + " ");
            }
        }
    }
}

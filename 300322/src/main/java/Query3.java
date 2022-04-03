import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Query3 extends Thread {
    public void run(Statement stm) throws SQLException {
        String sqlQuery = "SELECT Nazione, COUNT(Dipendente) " +
                          "FROM AUTOFFICINA.AUTO;";

        ResultSet resSet = stm.executeQuery(sqlQuery);
        ResultSetMetaData md = resSet.getMetaData();

        while (resSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.println(resSet.getString(i));
            }
        }
    }
}

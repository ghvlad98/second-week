import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends Thread {
    public void run(Statement stm) throws SQLException {
        String sqlQuery = "SELECT Marchio, Fatturato " +
                                "FROM AUTOFFICINA.AUTO " +
                                "ORDER BY Fatturato DESC;";

        ResultSet resSet = stm.executeQuery(sqlQuery);
        ResultSetMetaData md = resSet.getMetaData();

        while (resSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.println(resSet.getString(i));
            }
        }
    }
}

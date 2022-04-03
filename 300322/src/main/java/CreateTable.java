import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends Thread {
    public void run(Statement stm) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS AUTOFFICINA.AUTO " +
                "(ID SERIAL not NULL, " +
                " Marchio VARCHAR(255), " +
                " Nazione VARCHAR(255), " +
                " Fatturato INTEGER, " +
                " Dipendenti VARCHAR(255), " +
                " PRIMARY KEY(ID))";

        stm.executeUpdate(sqlCreate);
    }
}

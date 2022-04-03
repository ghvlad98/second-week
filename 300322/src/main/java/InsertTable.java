import java.sql.*;

public class InsertTable extends Thread {
    public void run(Statement stm) throws SQLException {

        String[] sqlInsert = {"INSERT INTO AUTO VALUES (1, 'Fiat', 'Italia', 200000, 10000);",
                              "INSERT INTO AUTO VALUES (2, 'Alfa Romeo', 'Italia', 100000, 5000);",
                              "INSERT INTO AUTO VALUES (3, 'Toyota', 'Giappone', 400000, 12000);",
                              "INSERT INTO AUTO VALUES (4, 'Audi', 'Germania', 300000, 11000);",};

        for (String s: sqlInsert) {
            stm.executeUpdate(s);
        }
    }
}

package ex2;

import utils.ReadProperties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class JDBConnection {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
        ReadProperties rd = new ReadProperties();
        rd.read("application.properties");
        Class.forName(rd.getProperties().getProperty("mySqlUrl"));
        Connection con = DriverManager.getConnection(
                rd.getProperties().getProperty("urlDB"),
                rd.getProperties().getProperty("username"),
                rd.getProperties().getProperty("password"));

        Statement stm = con.createStatement();
        TableOperations op = new TableOperations();
        op.createDatabase(stm);
        op.createTablePersone(stm);
        op.createTableOrdini(stm);
        // op.insert(con);
        // op.update(con);
        // op.delete(con);
        // op.findByPrimaryKey(con);
        // op.findByForeignKey(con);
    }
}

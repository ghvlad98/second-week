package ex2;

import java.sql.*;
import java.util.Scanner;

public class TableOperations implements Operations<Connection> {

    public void createDatabase(Statement stm) throws SQLException {
        String sqlDatabase = "CREATE DATABASE IF NOT EXISTS MARKET";
        stm.executeUpdate(sqlDatabase);
    }

    public void createTableOrdini(Statement stm) throws SQLException {
        String sqlTable = "CREATE TABLE IF NOT EXISTS MARKET.Ordini " +
                "(OrderID INT NOT NULL, " +
                " PersonID INT NOT NULL," +
                " FOREIGN KEY(PersonID) REFERENCES MARKET.Persone(ID)," +
                " PRIMARY KEY(OrderID))";
        stm.executeUpdate(sqlTable);
    }

    public void createTablePersone(Statement stm) throws SQLException {
        String sqlTable = "CREATE TABLE IF NOT EXISTS MARKET.Persone " +
                "(ID INT NOT NULL, " +
                " firstName VARCHAR(255) NOT NULL," +
                " lastName VARCHAR(255) NOT NULL," +
                " age VARCHAR(255) NOT NULL," +
                " PRIMARY KEY(ID))";
        stm.executeUpdate(sqlTable);
    }

    @Override
    public void insert(Connection o) throws SQLException {
        Person per = new Person();
        per.data();
        int id = per.getId();
        String firstName = per.getFirstName();
        String lastName = per.getLastName();
        int age = per.getAge();

        String sqlInsert = "INSERT INTO MARKET.Persone (ID, firstName, lastName, age) VALUES (?, ?, ?, ?);";
        PreparedStatement ins = o.prepareStatement(sqlInsert);
        ins.setInt(1, id);
        ins.setString(2, firstName);
        ins.setString(3, lastName);
        ins.setInt(4, age);
        ins.executeUpdate();

        Scanner in = new Scanner(System.in);
        System.out.println("Tell me if this person ordered something: (y/n)");
        String answer = in.next();
        if (answer.equals("y")) {
            System.out.println("What is the order number?");
            int orderID = in.nextInt();
            String sqlInsert2 = "INSERT INTO MARKET.Ordini (OrderID, PersonID) VALUES (?, ?);";
            PreparedStatement ins2 = o.prepareStatement(sqlInsert2);
            ins2.setInt(1, orderID);
            ins2.setInt(2, id);
            ins2.executeUpdate();
        }
    }

    @Override
    public void update(Connection o) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the id of the person that you want to modify:");
        int id = in.nextInt();
        System.out.println("Write new first name for person:");
        String firstName = in.next();
        System.out.println("Write new last name for person:");
        String lastName = in.next();
        System.out.println("Write new age for person:");
        int age = in.nextInt();
        String sqlUpdate = "UPDATE MARKET.Persone SET firstName = ?, lastName = ?, age = ? WHERE ID = ?";
        PreparedStatement ins = o.prepareStatement(sqlUpdate);
        ins.setString(1, firstName);
        ins.setString(2, lastName);
        ins.setInt(3, age);
        ins.setInt(4, id);
        ins.executeUpdate();
    }

    @Override
    public void delete(Connection o) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the id of the person that you want to remove (this will also remove the associated orders):");
        int id = in.nextInt();
        String sqlDelete = "DELETE FROM MARKET.Persone WHERE ID = ?";
        PreparedStatement del = o.prepareStatement(sqlDelete);
        del.setInt(1, id);

        String sqlDelete2 = "DELETE FROM MARKET.Ordini WHERE PersonID = ?";
        PreparedStatement del2 = o.prepareStatement(sqlDelete2);
        del2.setInt(1, id);
        del2.executeUpdate();
        del.executeUpdate();
    }

    @Override
    public void findByPrimaryKey(Connection o) throws SQLException {
        Statement stm = o.createStatement();
        Statement stm2 = o.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.println("Write the ID for the person that you want to find (if the person has orders, will also be displayed):");
        int id = in.nextInt();
        String sqlFindPK = "SELECT * FROM MARKET.Persone WHERE ID = " + id;
        ResultSet resSetP = stm.executeQuery(sqlFindPK);
        String sqlFindPK2 = "SELECT * FROM MARKET.Ordini WHERE PersonID = " + id;
        ResultSet resSetO = stm2.executeQuery(sqlFindPK2);
        ResultSetMetaData md1 = resSetP.getMetaData();
        ResultSetMetaData md2 = resSetO.getMetaData();

        if (resSetP.next()) {
            System.out.println("Data of person:");
            for (int i = 1; i <= md1.getColumnCount(); i++) {
                System.out.print(resSetP.getString(i) + " ");
            }
        }

        System.out.println();

        if (resSetO.next()) {
            System.out.println("Data of orders:");
            for (int i = 1; i <= md2.getColumnCount(); i++) {
                System.out.print(resSetO.getString(i) + " ");
            }
        }
    }

    @Override
    public void findByForeignKey(Connection o) throws SQLException {
        Statement stm = o.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.println("Write the OrderID for the person that you want to find:");
        int id = in.nextInt();
        String sqlFindFK = "SELECT PersonID FROM MARKET.Ordini WHERE OrderID = " + id;
        ResultSet resSet = stm.executeQuery(sqlFindFK);
        ResultSetMetaData md = resSet.getMetaData();

        if (resSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.println(resSet.getString(i));
            }
        }
    }
}

package ex1;

import lombok.Builder;
import utils.ReadProperties;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class NewCon {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        ReadProperties rd = new ReadProperties();
        rd.read("application.properties");
        Class.forName(rd.getProperties().getProperty("mySqlUrl"));
        Connection con = DriverManager.getConnection(rd.getProperties().getProperty("urlDB"),
                                                    rd.getProperties().getProperty("username"),
                                                    rd.getProperties().getProperty("password"));
        Statement stm = con.createStatement();
        CreateTable thrCreate = new CreateTable();
        thrCreate.run(stm);

        // NewCon.insertRow(con);
        // NewCon.deleteRow(con);
        // NewCon.destroy(con);
        // ReadTable thrRead = new ReadTable();
        // thrRead.run(stm);
    }

    @Logger("We're in method insertRow and this method inserts new data for an employee")
    public static void insertRow(Connection con) throws SQLException {
        Employee emp = new Employee();
        emp.insert();
        int id = emp.getId();
        String name = emp.getName();
        String lastName = emp.getLastName();
        String sqlInsert = "INSERT INTO Employee (ID, Name, LastName) VALUES (?, ?, ?);";
        PreparedStatement ins = con.prepareStatement(sqlInsert);
        ins.setInt(1, id);
        ins.setString(2, name);
        ins.setString(3, lastName);
        ins.executeUpdate();
    }

    @Logger("We're in method deleteRow and this method deletes data for an employee")
    public static void deleteRow(Connection con) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the id of the employee that you want to remove:");
        int id = in.nextInt();
        String sqlDelete = "DELETE FROM Employee WHERE ID = ?";
        PreparedStatement ins = con.prepareStatement(sqlDelete);
        ins.setInt(1, id);
        ins.executeUpdate();
    }

    @Logger("We're in method destroy and this method deletes all data")
    public static void destroy(Connection con) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you sure you want to delete the table? (confirm with 'y')");
        if (in.next() == "y") {
            String sqlDrop = "DROP TABLE Employee";
            Statement stm = con.createStatement();
            stm.executeUpdate(sqlDrop);
        }
    }
}

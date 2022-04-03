package ex1;

import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class NewCon implements Repository {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException, ParseException {
        ReadProperties rd = new ReadProperties();
        rd.read("application.properties");
        Class.forName(rd.getProperties().getProperty("mySqlUrl"));
        Connection con = DriverManager.getConnection(rd.getProperties().getProperty("urlDB"),
                                                    rd.getProperties().getProperty("username"),
                                                    rd.getProperties().getProperty("password"));
        Statement stm = con.createStatement();
        NewCon.createDatabase(stm);
        NewCon.createTable(stm);
        NewCon nc = new NewCon();
        // nc.persist(con);
        // nc.update(con);
        nc.findPrimaryKey(stm);
    }

    public static void createDatabase(Statement stm) throws SQLException {
        String sqlDatabase = "CREATE DATABASE IF NOT EXISTS OLYMPIC";
        stm.executeUpdate(sqlDatabase);
    }

    public static void createTable(Statement stm) throws SQLException {
        String sqlTable = "CREATE TABLE IF NOT EXISTS OLYMPIC.Athletes " +
                "(Code INT not NULL, " +
                " Name VARCHAR(255), " +
                " Nation VARCHAR(255), " +
                " BirthDate DATE, " +
                " Height DOUBLE, " +
                " PRIMARY KEY(Code))";
        stm.executeUpdate(sqlTable);
    }

    public void persist(Object obj) throws SQLException, ParseException {
        Athlete ath = new Athlete();
        ath.data();
        int code = ath.getCode();
        String name = ath.getName();
        String nation = ath.getNation();
        Date birthDate = ath.getBirthDate();
        double height = ath.getHeight();

        String sqlInsert = "INSERT INTO OLYMPIC.Athletes (Code, Name, Nation, BirthDate, Height) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ins = ((Connection) obj).prepareStatement(sqlInsert);
        ins.setInt(1, code);
        ins.setString(2, name);
        ins.setString(3, nation);
        ins.setDate(4, birthDate);
        ins.setDouble(5, height);
        ins.executeUpdate();
    }

    public void delete(Object obj) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the code of the athlete that you want to remove:");
        int code = in.nextInt();
        String sqlDelete = "DELETE FROM OLYMPIC.Athletes WHERE Code = ?";
        PreparedStatement ins = ((Connection) obj).prepareStatement(sqlDelete);
        ins.setInt(1, code);
        ins.executeUpdate();
    }

    public void update(Object obj) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the code of the athlete that you want to modify:");
        int code = in.nextInt();
        System.out.println("Write new name for athlete:");
        String name = in.next();
        System.out.println("Write new nation for athlete:");
        String nation = in.next();
        System.out.println("Write new birth date for athlete (yyyy-MM-dd):");
        String date = in.next();
        java.sql.Date birthDate = Date.valueOf(date);
        System.out.println("Write new height for athlete:");
        double height = in.nextDouble();
        String sqlUpdate = "UPDATE OLYMPIC.Athletes SET Name = ?, Nation = ?, BirthDate = ?, Height = ? WHERE Code = ?";
        PreparedStatement ins = ((Connection) obj).prepareStatement(sqlUpdate);
        ins.setString(1, name);
        ins.setString(2, nation);
        ins.setDate(3, birthDate);
        ins.setDouble(4, height);
        ins.setInt(5, code);
        ins.executeUpdate();
    }

    public void findPrimaryKey(Statement stm) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the code for the athlete that you want to find:");
        int code = in.nextInt();
        String sqlFind = "SELECT * FROM OLYMPIC.Athletes WHERE Code = " + code;
        ResultSet resSet = stm.executeQuery(sqlFind);
        ResultSetMetaData md = resSet.getMetaData();
        while (resSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.println(resSet.getString(i));
            }
        }
    }
}

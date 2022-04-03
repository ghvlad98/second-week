import java.sql.*;

public class NewCon {
    /*
    basi di dati auto con campi id, marchio, nazione, fatturato, dipendenti
    elanca marchio e fatturato discendente
    elenca numero dipendenti per nazione
    elenca per ogni marchio il fatturato
    elenca fatturato per nazione decrescente
    query per id
    delete record
    (ognuno in thread diversi)
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/AUTOFFICINA", "root", "<WannaCry17>");
        Statement stm = con.createStatement();

        CreateTable thread1 = new CreateTable();
        thread1.setPriority(1);
        thread1.run(stm);

        /*
        InsertTable thread2 = new InsertTable();
        thread2.setPriority(2);
        thread2.run(stm);
        */

        System.out.println("elanca marchio e fatturato discendente:");
        Query thread3 = new Query();
        thread3.setPriority(3);
        thread3.run(stm);

        System.out.println("elenca numero marchi per nazione");
        Query2 thread4 = new Query2();
        thread4.setPriority(4);
        thread4.run(stm);

        System.out.println("elenca numero dipendenti per nazione");
        Query3 thread5 = new Query3();
        thread5.setPriority(5);
        thread5.run(stm);

        System.out.println("elenca fatturato per nazione decrescente");
        Query4 thread6 = new Query4();
        thread6.setPriority(6);
        thread6.run(stm);
    }
}

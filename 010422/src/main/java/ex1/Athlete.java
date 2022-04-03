package ex1;

import lombok.Data;

import java.text.ParseException;
import java.sql.Date;
import java.util.Scanner;

@Data
public class Athlete {
    private int code;
    private String name;
    private String nation;
    private java.sql.Date birthDate;
    private double height;

    public void data() throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("Write code for athlete:");
        this.code = in.nextInt();
        System.out.println("Write name for athlete:");
        this.name = in.next();
        System.out.println("Write nation for athlete:");
        this.name = in.next();
        System.out.println("Write birth date for athlete (yyyy-MM-dd):");
        String date = in.next();
        this.birthDate = Date.valueOf(date);
        System.out.println("Write height for athlete:");
        this.height = in.nextDouble();
    }
}

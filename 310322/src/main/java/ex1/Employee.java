package ex1;

import lombok.Data;

import java.sql.Statement;
import java.util.Scanner;

@Data
public class Employee implements command {
    private int id;
    private String name;
    private String lastName;

    public void insert() {
        Scanner in = new Scanner(System.in);
        System.out.println("Write an id for the employee: ");
        this.id = in.nextInt();
        System.out.println("Write a name for the employee: ");
        this.name = in.next();
        System.out.println("Write a lastName for the employee: ");
        this.lastName = in.next();
    }
}

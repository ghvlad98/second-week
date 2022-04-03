package ex2;

import lombok.Data;
import java.util.Scanner;

@Data
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public void data() {
        Scanner in = new Scanner(System.in);
        System.out.println("Write id for person:");
        this.id = in.nextInt();
        System.out.println("Write first name for person:");
        this.firstName = in.next();
        System.out.println("Write last name for person:");
        this.lastName = in.next();
        System.out.println("Write age for person:");
        this.age = in.nextInt();
    }
}

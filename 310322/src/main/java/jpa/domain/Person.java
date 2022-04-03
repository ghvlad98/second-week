package jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private String id;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String lastName;

    @OneToMany(
            mappedBy = "family"
            ,cascade = {CascadeType.ALL}
    )
    private List<Person> persons = new ArrayList<Person>();
}

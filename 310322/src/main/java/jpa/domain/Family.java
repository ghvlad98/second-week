package jpa.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="family_id")
    private String id;

    @Column(length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}

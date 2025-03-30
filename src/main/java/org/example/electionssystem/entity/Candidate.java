package org.example.electionssystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Gurgen Bayburdyan
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "candidate") //todo please make uppercase
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_Name", nullable = false) //todo please add length limit
    private String firstName;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "number")
    private Integer number;

}

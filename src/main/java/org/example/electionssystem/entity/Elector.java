package org.example.electionssystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Gurgen Bayburdyan
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "elector")
    //todo the elector should have an assigned location, and it must be only 1

public class Elector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_Name", nullable = false)
    private String firstName;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "date_Of_Birth", nullable = false)
    private LocalDateTime dateOfBirth;

}

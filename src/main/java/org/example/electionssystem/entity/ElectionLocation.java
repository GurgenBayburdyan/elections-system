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
@Table(name = "election_location")
public class ElectionLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

}

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
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "elector_id", nullable = false, foreignKey = @ForeignKey(name = "FK_VOTE_ELECTOR_ID"))
    private Elector elector;

    @ManyToOne
    @JoinColumn(name = "election_location_id", nullable = false, foreignKey = @ForeignKey(name = "FK_VOTE_ELECTION_LOCATION_ID"))
    private ElectionLocation electionLocation;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false, foreignKey = @ForeignKey(name = "FK_VOTE_CANDIDATE_ID"))
    private Candidate candidate;

}

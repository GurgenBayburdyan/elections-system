package org.example.electionssystem.service.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

/**
 * @author Gurgen Bayburdyan
 */

@Setter
@Getter
@ToString
public class CreateVoteParams {

    private final Long electorId;
    private final Long electionLocationId;
    private final Long candidateId;

    public CreateVoteParams(Long electorId, Long electionLocationId, Long candidateId) {
        Assert.notNull(electorId, "the elector id should not be null");
        this.electorId = electorId;
        Assert.notNull(electionLocationId, "the election location id should not be null");
        this.electionLocationId = electionLocationId;
        Assert.notNull(candidateId, "the candidate id should not be null");
        this.candidateId = candidateId;
    }
}

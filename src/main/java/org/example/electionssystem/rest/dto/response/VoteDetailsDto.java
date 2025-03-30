package org.example.electionssystem.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gurgen Bayburdyan
 */

@Setter
@Getter
@ToString
public class VoteDetailsDto extends AbstractErrorAwareDetailsDto {

    @JsonProperty("electorId")
    private Long electorId;

    @JsonProperty("electionLocationId")
    private Long electionLocationId;

    @JsonProperty("candidateId")
    private Long candidateId;

    public VoteDetailsDto(ErrorType errorType) {
        super(errorType);
    }

    public VoteDetailsDto() {
        super(null);
    }
}

package org.example.electionssystem.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gurgen Bayburdyan
 */

@Getter
@Setter
@ToString
public class CandidateDetailsDto extends AbstractErrorAwareDetailsDto {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("number")
    private Integer number;

    public CandidateDetailsDto(ErrorType errorType) {
        super(errorType);
    }

    public CandidateDetailsDto() {
        super(null);
    }
}

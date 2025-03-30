package org.example.electionssystem.rest.dto.request;

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
public class CreateCandidateRequestDto {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("number")
    private Integer number;

}

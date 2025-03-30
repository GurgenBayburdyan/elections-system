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
public class CreateElectionLocationRequestDto {

    @JsonProperty("address")
    private String address;

}

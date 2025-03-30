package org.example.electionssystem.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gurgen Bayburdyan
 */

@Setter
@Getter
@AllArgsConstructor
public abstract class AbstractErrorAwareDetailsDto {

    @JsonProperty("errorType")
    private ErrorType errorType;

}

package org.example.electionssystem.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Gurgen Bayburdyan
 */

@Getter
@Setter
@ToString
public class ElectorDetailsDto extends AbstractErrorAwareDetailsDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("dateOfBirth")
    private LocalDateTime dateOfBirth;

    @JsonProperty("passportNumber")
    private String passportNumber;

    public ElectorDetailsDto(ErrorType errorType) {
        super(errorType);
    }

    public ElectorDetailsDto() {
        super(null);
    }
}

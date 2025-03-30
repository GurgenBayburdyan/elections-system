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
public class ElectionLocationDetailsDto extends AbstractErrorAwareDetailsDto {

    @JsonProperty("address")
    private String address;

    public ElectionLocationDetailsDto(ErrorType errorType) {
        super(errorType);
    }

    public ElectionLocationDetailsDto() {
        super(null);
    }
}

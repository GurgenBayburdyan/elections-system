package org.example.electionssystem.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @author Gurgen Bayburdyan
 */

@Setter
@Getter
@ToString
public class StatisticsDetailsDto {

    @JsonProperty("voteCount")
    private Integer voteCount;

    @JsonProperty("candidateCount")
    private Integer candidateCount;

    @JsonProperty("electorCount")
    private Integer electorCount;

    @JsonProperty("electionLocationCount")
    private Integer electionLocationCount;

    @JsonProperty("statistics")
    private Map<Long, Map<Long, Float>> statistics;

}

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
public class CreateCandidateParams {

    private final String firstName;
    private final String lastName;
    private final Integer number;

    public CreateCandidateParams(String firstName, String lastName, Integer number) {
        Assert.notNull(firstName, "the first name should not be null");
        this.firstName = firstName;
        Assert.notNull(lastName, "the last name should not be null");
        this.lastName = lastName;
        Assert.notNull(number, "the number should not be null");
        this.number = number;
    }
}

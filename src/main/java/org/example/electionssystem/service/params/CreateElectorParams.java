package org.example.electionssystem.service.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * @author Gurgen Bayburdyan
 */

@Setter
@Getter
@ToString
public class CreateElectorParams {

    private final String firstName;
    private final String lastName;
    private final LocalDateTime dateOfBirth;
    private final String passportNumber;
    public CreateElectorParams(String firstName, String lastName, LocalDateTime dateOfBirth, String passportNumber) {
        Assert.notNull(firstName, "the first name should not be null");
        this.firstName = firstName;
        Assert.notNull(lastName, "the last name should not be null");
        this.lastName = lastName;
        Assert.notNull(firstName, "the date of birth should not be null");
        this.dateOfBirth = dateOfBirth;
        Assert.notNull(passportNumber, "the passport number should not be null");
        this.passportNumber = passportNumber;
    }
}

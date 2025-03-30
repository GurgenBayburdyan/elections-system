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
public class CreateElectionLocationParams {

    private final String address;

    public CreateElectionLocationParams(String address) {
        Assert.notNull(address, "the address should not be null");
        this.address = address;
    }
}

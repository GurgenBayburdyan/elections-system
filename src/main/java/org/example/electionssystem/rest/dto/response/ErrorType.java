package org.example.electionssystem.rest.dto.response;

/**
 * @author Gurgen Bayburdyan
 */

public enum ErrorType {
    MISSING_FIRST_NAME,
    MISSING_LAST_NAME,
    MISSING_DATE_OF_BIRTH,
    MISSING_ADDRESS,
    MISSING_NUMBER,
    MISSING_CANDIDATE_ID,
    MISSING_ELECTOR_ID,
    MISSING_ELECTION_LOCATION_ID,
    MISSING_PASSPORT_NUMBER,
    CANDIDATE_NOT_FOUND,
    ELECTOR_NOT_FOUND,
    ELECTION_LOCATION_NOT_FOUND,
    ELECTOR_ALREADY_VOTED,
}

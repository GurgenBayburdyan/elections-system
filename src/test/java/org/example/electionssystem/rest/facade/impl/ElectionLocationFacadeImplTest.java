package org.example.electionssystem.rest.facade.impl;

import org.example.electionssystem.entity.ElectionLocation;
import org.example.electionssystem.mapper.ElectionLocationMapper;
import org.example.electionssystem.rest.dto.request.CreateElectionLocationRequestDto;
import org.example.electionssystem.rest.dto.response.ElectionLocationDetailsDto;
import org.example.electionssystem.rest.dto.response.ErrorType;
import org.example.electionssystem.rest.facade.ElectionLocationFacade;
import org.example.electionssystem.rest.facade.validator.ElectionLocationValidator;
import org.example.electionssystem.service.ElectionLocationService;
import org.example.electionssystem.service.params.CreateElectionLocationParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class ElectionLocationFacadeImplTest {

    @Mock
    private ElectionLocationService electionLocationService;

    @Mock
    private ElectionLocationMapper electionLocationMapper;

    @Mock
    private ElectionLocationValidator electionLocationValidator;

    private ElectionLocationFacade electionLocationFacade;

    @BeforeEach
    void setUp() {
        electionLocationFacade = new ElectionLocationFacadeImpl(electionLocationService, electionLocationMapper, electionLocationValidator);
    }

    @Test
    void getAll() {
        List<ElectionLocation> electionLocations = new ArrayList<>();
        List<ElectionLocationDetailsDto> detailsDtos = new ArrayList<>();

        when(electionLocationService.getAll()).thenReturn(electionLocations);
        when(electionLocationMapper.toDetailsDtoList(electionLocations)).thenReturn(detailsDtos);

        List<ElectionLocationDetailsDto> result = electionLocationFacade.findAll();

        assertEquals(detailsDtos, result);

        verify(electionLocationService).getAll();
        verify(electionLocationMapper).toDetailsDtoList(electionLocations);
    }

    @Test
    void create_success() {
        CreateElectionLocationRequestDto requestDto = new CreateElectionLocationRequestDto();
        ElectionLocation electionLocation = new ElectionLocation();
        ElectionLocationDetailsDto detailsDto = new ElectionLocationDetailsDto();

        CreateElectionLocationParams params = new CreateElectionLocationParams(
                "address"
        );

        when(electionLocationValidator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(electionLocationMapper.toCreateParams(requestDto)).thenReturn(params);
        when(electionLocationService.create(params)).thenReturn(electionLocation);
        when(electionLocationMapper.toDetailsDto(electionLocation)).thenReturn(detailsDto);

        ElectionLocationDetailsDto result = electionLocationFacade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(electionLocationValidator).validateCreate(requestDto);
        verify(electionLocationService).create(params);
        verify(electionLocationMapper).toCreateParams(requestDto);
    }

    @Test
    void create_MissingAddress() {
        CreateElectionLocationRequestDto requestDto = new CreateElectionLocationRequestDto();
        when(electionLocationValidator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_ADDRESS));

        ElectionLocationDetailsDto result = electionLocationFacade.create(requestDto);

        assertEquals(ErrorType.MISSING_ADDRESS, result.getErrorType());

        verify(electionLocationValidator).validateCreate(requestDto);
    }

}
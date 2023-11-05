package cloud.kaivola.devacademyassignment;

import cloud.kaivola.devacademyassignment.station.Station;
import cloud.kaivola.devacademyassignment.station.StationDto;
import cloud.kaivola.devacademyassignment.station.StationRepository;
import cloud.kaivola.devacademyassignment.station.StationService;
import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class StationServiceTest {

    private static StationService stationService;

    @BeforeAll
    static void setupServices() {
        StationRepository stationRepository = mock(StationRepository.class);
        StatisticsService statisticsService = mock(StatisticsService.class);
        stationService = new StationService(stationRepository, statisticsService);
    }

    @Test
    void shouldFormatDistanceAndDurationCorrectly() {
        StationStatistics statistics1 = new StationStatistics(10, 50, 150.9, 1.0001000);
        Station s1 = new Station(1, "Station 1", "Address 1", "0.0", "0.0", statistics1);

        StationDto dto1 = stationService.mapStationToDto(s1);
        assertEquals(150.9, dto1.getAverageDistanceOfJourneys());
        assertEquals(1, dto1.getAverageDurationOfJourneys());
    }

    @Test
    void shouldConvertCoordinatesToFloats() {
        Station s1 = new Station(1, "Station 1", "Address 1", "61.0", "25.0", null);
        StationDto dto1 = stationService.mapStationToDto(s1);

        assertEquals(61.0, dto1.getCoordinateX());
        assertEquals(25.0, dto1.getCoordinateY());
    }

    @Test
    void shouldMapStationToDto() {
        StationStatistics statistics1 = new StationStatistics(10, 50, 150.9, 1.0001000);
        Station s1 = new Station(1, "Station 1", "Address 1", "0.0", "0.0", statistics1);
        StationDto dto1 = stationService.mapStationToDto(s1);
        assertEquals(s1.getId(), dto1.getId());
        assertEquals(s1.getStationName(), dto1.getName());
        assertEquals(s1.getStationAddress(), dto1.getAddress());
        assertNotNull(dto1.getCoordinateY());
        assertNotNull(dto1.getCoordinateX());
        assertNotNull(dto1.getNumOfJourneysStarting());
        assertNotNull(dto1.getNumOfJourneysEnding());
        assertNotNull(dto1.getAverageDistanceOfJourneys());
        assertNotNull(dto1.getAverageDurationOfJourneys());
    }


    @Test
    void shouldMapStationToDtoWithoutStatistics() {
        Station s1 = new Station(1, "Station 1", "Address 1", "0.0", "0.0", null);
        StationDto dto1 = stationService.mapStationToDto(s1);
        assertEquals(s1.getId(), dto1.getId());
        assertEquals(s1.getStationName(), dto1.getName());
        assertEquals(s1.getStationAddress(), dto1.getAddress());
        assertNotNull(dto1.getCoordinateY());
        assertNotNull(dto1.getCoordinateX());
        assertNull(dto1.getNumOfJourneysStarting());
        assertNull(dto1.getNumOfJourneysEnding());
        assertNull(dto1.getAverageDistanceOfJourneys());
        assertNull(dto1.getAverageDurationOfJourneys());
    }
}

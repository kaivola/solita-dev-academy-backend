package cloud.kaivola.devacademyassignment;

import cloud.kaivola.devacademyassignment.station.Station;
import cloud.kaivola.devacademyassignment.station.StationDto;
import cloud.kaivola.devacademyassignment.station.StationRepository;
import cloud.kaivola.devacademyassignment.station.StationService;
import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        StationStatistics statistics1 = new StationStatistics(10, 50, 150.99999, 1.0001000);
        Station s1 = new Station(1, "Station 1", "Address 1", "0.0", "0.0", statistics1);

        StationDto dto1 = stationService.mapStationToStationDto(s1);
        assertEquals("151.0", dto1.averageDistanceOfJourneys());
        assertEquals(1, dto1.averageDurationOfJourneys());
    }

}

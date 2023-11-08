package cloud.kaivola.devacademyassignment;

import cloud.kaivola.devacademyassignment.journey.Journey;
import cloud.kaivola.devacademyassignment.journey.JourneyRepository;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class StatisticsServiceTest {

    private static StatisticsService statisticsService;

    @BeforeAll
    static void setupServices() {
        JourneyRepository journeyRepository = mock(JourneyRepository.class);
        statisticsService = new StatisticsService(journeyRepository);
    }

    @Test
    void shouldCalculateAverageDistance() {
        Journey j1 = new Journey();
        j1.setDistance(100);
        Journey j2 = new Journey();
        j2.setDistance(150);
        Journey j3 = new Journey();
        j3.setDistance(200);
        List<Journey> journeys = List.of(j1, j2, j3);

        Double res = statisticsService.calculateAverageDistance(journeys);
        assertEquals(150.0, res);
    }

    @Test
    void shouldCalculateAverageDistanceWithMissingValues() {
        Journey j1 = new Journey();
        j1.setDistance(100);
        Journey j2 = new Journey();
        Journey j3 = new Journey();
        j3.setDistance(200);
        List<Journey> journeys = List.of(j1, j2, j3);

        Double res = statisticsService.calculateAverageDistance(journeys);
        assertEquals(150.0, res);
    }

    @Test
    void shouldCalculateAverageDuration() {
        Journey j1 = new Journey();
        j1.setDuration(100);
        Journey j2 = new Journey();
        j2.setDuration(150);
        Journey j3 = new Journey();
        j3.setDuration(200);
        List<Journey> journeys = List.of(j1, j2, j3);

        Double res = statisticsService.calculateAverageDuration(journeys);
        assertEquals(150.0, res);
    }

    @Test
    void shouldCalculateAverageDurationWithMissingValues() {
        Journey j1 = new Journey();
        j1.setDuration(100);
        Journey j2 = new Journey();
        Journey j3 = new Journey();
        j3.setDuration(200);
        List<Journey> journeys = List.of(j1, j2, j3);

        Double res = statisticsService.calculateAverageDuration(journeys);
        assertEquals(150.0, res);
    }

    @Test
    void shouldGetTopDestinations() {
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Journey j1 = new Journey();
            j1.setId(i);
            if (i < 2) {
                j1.setReturnStationId(1);
            } else if (i < 6) {
                j1.setReturnStationId(2);
            } else {
                j1.setReturnStationId(i);
            }
            journeys.add(j1);
        }
        Map<Integer, Long> res = statisticsService.getTopDestinationIds(journeys);

        assertEquals(res.size(), 5);
        assertEquals(res.get(1), 2);
        assertEquals(res.get(2), 4);
    }
}

package cloud.kaivola.devacademyassignment;

import cloud.kaivola.devacademyassignment.journey.Journey;
import cloud.kaivola.devacademyassignment.journey.JourneyRepository;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {

    private static StatisticsService statisticsService;

    @BeforeAll
    static void setupServices() {
        JourneyRepository journeyRepository = mock(JourneyRepository.class);
        statisticsService = new StatisticsService(journeyRepository);
    }

    @Test
    void shouldCalculateAverageDistances() {
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
}

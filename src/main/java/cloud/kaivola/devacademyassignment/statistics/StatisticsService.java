package cloud.kaivola.devacademyassignment.statistics;

import cloud.kaivola.devacademyassignment.journey.Journey;
import cloud.kaivola.devacademyassignment.journey.JourneyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private final JourneyRepository journeyRepository;

    public StatisticsService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public StationStatistics getStationStatisticsById(Integer stationId) {
        StationStatistics statistics = new StationStatistics();
        List<Journey> startingJourneys = journeyRepository.findAllByDepartureStationId(stationId);

        statistics.setNumOfJourneysStarting(startingJourneys.size());
        statistics.setNumOfJourneysEnding(journeyRepository.getNumOfEndingJourneysByStationId(stationId));
        return statistics;
    }

    public Double calculateAverageDistance(List<Journey> journeys) {
        return journeys.stream().collect(Collectors.averagingDouble(Journey::getDistance));
    }
}

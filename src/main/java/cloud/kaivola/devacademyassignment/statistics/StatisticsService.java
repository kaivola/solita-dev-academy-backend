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
        statistics.setAverageDistanceOfJourneys(calculateAverageDistance(startingJourneys));
        statistics.setAverageDurationOfJourneys(calculateAverageDuration(startingJourneys));
        return statistics;
    }

    public Double calculateAverageDistance(List<Journey> journeys) {
        return journeys.stream().filter(journey -> journey.getDistance() != null).collect(Collectors.averagingDouble(Journey::getDistance));
    }

    public Double calculateAverageDuration(List<Journey> journeys) {
        return journeys.stream().filter(journey -> journey.getDuration() != null).collect(Collectors.averagingDouble(Journey::getDuration));
    }
}

package cloud.kaivola.devacademyassignment.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationStatistics {
    private Integer numOfJourneysStarting;
    private Integer numOfJourneysEnding;
    private Double averageDistanceOfJourneys;
    private Double averageDurationOfJourneys;
}

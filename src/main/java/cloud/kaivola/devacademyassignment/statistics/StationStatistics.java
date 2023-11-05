package cloud.kaivola.devacademyassignment.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StationStatistics {
    private Integer numOfJourneysStarting;
    private Integer numOfJourneysEnding;
    private Double averageDistanceOfJourneys;
    private Double averageDurationOfJourneys;
}

package cloud.kaivola.devacademyassignment.statistics;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StationStatistics {
    private Integer numOfJourneysStarting;
    private Integer numOfJourneysEnding;
    private Double averageDistanceOfJourneys;
    private Double averageDurationOfJourneys;
    private Map<Integer, Long> topDestinationIds;
}

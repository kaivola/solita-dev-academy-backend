package cloud.kaivola.devacademyassignment.station;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationDto {
        Integer id;
        String name;
        String address;
        Double coordinateX;
        Double coordinateY;
        Integer numOfJourneysStarting;
        Integer numOfJourneysEnding;
        Double averageDistanceOfJourneys;
        Integer averageDurationOfJourneys;
        List<TopDestinationPair> topDestinations;
}

package cloud.kaivola.devacademyassignment.station;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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
}

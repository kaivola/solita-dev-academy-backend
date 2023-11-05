package cloud.kaivola.devacademyassignment.station;


import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Table(name = "station")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "station_name", length = 100)
    private String stationName;

    @Column(name = "station_address", length = 100)
    private String stationAddress;

    @Column(name = "coordinate_x", length = 100)
    private String coordinateX;

    @Column(name = "coordinate_y", length = 100)
    private String coordinateY;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StationStatistics statistics;
}

package cloud.kaivola.devacademyassignment.station;


import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "station")
@Entity
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
    private StationStatistics statistics;
}

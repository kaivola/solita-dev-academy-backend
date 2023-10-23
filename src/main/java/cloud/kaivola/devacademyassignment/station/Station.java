package cloud.kaivola.devacademyassignment.station;


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

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_address")
    private String stationAddress;

    @Column(name = "coordinate_x")
    private String coordinateX;

    @Column(name = "coordinate_y")
    private String coordinateY;
}

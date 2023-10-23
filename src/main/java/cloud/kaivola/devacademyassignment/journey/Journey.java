package cloud.kaivola.devacademyassignment.journey;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "journey")
@Entity
public class Journey {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(name = "return_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column(name = "departure_station_id")
    private Integer departureStationId;

    @Column(name = "return_station_id")
    private Integer returnStationId;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "duration")
    private Integer duration;
}

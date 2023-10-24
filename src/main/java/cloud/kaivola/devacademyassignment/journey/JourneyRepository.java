package cloud.kaivola.devacademyassignment.journey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JourneyRepository  extends JpaRepository<Journey, Integer> {
    List<Journey> findAllByDepartureStationId(Integer id);

    List<Journey> findAllByReturnStationId(Integer id);

    @Query(value = "SELECT COUNT(id) FROM journey WHERE return_station_id = :stationId", nativeQuery = true)
    Integer getNumOfEndingJourneysByStationId(@Param("stationId") Integer stationId);
}

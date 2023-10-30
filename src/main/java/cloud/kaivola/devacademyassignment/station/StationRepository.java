package cloud.kaivola.devacademyassignment.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    List<Station> findAllByOrderByStationNameAsc();
}

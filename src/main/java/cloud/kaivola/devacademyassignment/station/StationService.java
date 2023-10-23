package cloud.kaivola.devacademyassignment.station;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Page<Station> getStations(Integer page) {
        return stationRepository.findAll(PageRequest.of(page, 30));
    }

    public Station getStationById(Long id) {
        return stationRepository.findById(id).orElseThrow();
    }

}

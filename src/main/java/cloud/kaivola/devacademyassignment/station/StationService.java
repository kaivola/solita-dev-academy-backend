package cloud.kaivola.devacademyassignment.station;

import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final StatisticsService statisticsService;

    public StationService(StationRepository stationRepository, StatisticsService statisticsService) {
        this.stationRepository = stationRepository;
        this.statisticsService = statisticsService;
    }

    public Page<Station> getStations(Integer page) {
        return stationRepository.findAll(PageRequest.of(page, 30));
    }

    public Station getStationById(Integer id) {
        Station station = stationRepository.findById(id).orElseThrow();
        StationStatistics statistics = statisticsService.getStationStatisticsById(station.getId());
        station.setStatistics(statistics);
        return station;
    }
}

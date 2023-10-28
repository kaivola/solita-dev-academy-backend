package cloud.kaivola.devacademyassignment.station;

import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final StatisticsService statisticsService;

    public StationService(StationRepository stationRepository, StatisticsService statisticsService) {
        this.stationRepository = stationRepository;
        this.statisticsService = statisticsService;
    }

    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(Integer id) {
        Station station = stationRepository.findById(id).orElseThrow();
        StationStatistics statistics = statisticsService.getStationStatisticsById(station.getId());
        station.setStatistics(statistics);
        return station;
    }
}

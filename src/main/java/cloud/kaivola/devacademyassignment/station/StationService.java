package cloud.kaivola.devacademyassignment.station;

import cloud.kaivola.devacademyassignment.exceptions.ResourceNotFoundException;
import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
        return stationRepository.findAllByOrderByStationNameAsc();
    }

    public StationDto getStationById(Integer id) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station with id: " + id + " not found"));
        StationStatistics statistics = statisticsService.getStationStatisticsById(station.getId());
        station.setStatistics(statistics);
        return mapStationToStationDto(station);
    }

    public StationDto mapStationToStationDto(Station station) {
        DecimalFormat df = new DecimalFormat("#.0");
        String avgDistance = df.format(station.getStatistics().getAverageDistanceOfJourneys());
        Integer avgDuration = (int) Math.round(station.getStatistics().getAverageDurationOfJourneys());

        return new StationDto(
                station.getId(),
                station.getStationName(),
                station.getStationAddress(),
                station.getCoordinateX(),
                station.getCoordinateY(),
                station.getStatistics().getNumOfJourneysStarting(),
                station.getStatistics().getNumOfJourneysEnding(),
                avgDistance,
                avgDuration
        );
    }
}

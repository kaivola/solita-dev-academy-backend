package cloud.kaivola.devacademyassignment.station;

import cloud.kaivola.devacademyassignment.exceptions.ResourceNotFoundException;
import cloud.kaivola.devacademyassignment.statistics.StationStatistics;
import cloud.kaivola.devacademyassignment.statistics.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final StatisticsService statisticsService;

    public StationService(StationRepository stationRepository, StatisticsService statisticsService) {
        this.stationRepository = stationRepository;
        this.statisticsService = statisticsService;
    }

    public List<StationDto> getStations() {
        List<Station> stations = stationRepository.findAllByOrderByStationNameAsc();
        return stations.stream().map(this::mapStationToDto).collect(Collectors.toList());
    }

    public StationDto getStationById(Integer id) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station with id: " + id + " not found"));
        StationStatistics statistics = statisticsService.getStationStatisticsById(station.getId());
        station.setStatistics(statistics);
        return mapStationToDto(station);
    }

    public List<StationDto> getStationsByIds(Set<Integer> ids) {
        List<Station> stations = stationRepository.findAllById(ids);
        return stations.stream().map(this::mapStationToDto).collect(Collectors.toList());
    }

    public StationDto mapStationToDto(Station station) {
        StationDto stationDto = new StationDto();

        stationDto.setId(station.getId());
        stationDto.setName(station.getStationName());
        stationDto.setAddress(station.getStationAddress());
        stationDto.setCoordinateX(Double.parseDouble(station.getCoordinateX()));
        stationDto.setCoordinateY(Double.parseDouble(station.getCoordinateY()));

        if (station.getStatistics() != null) {
            StationStatistics statistics = station.getStatistics();
            stationDto.setNumOfJourneysStarting(statistics.getNumOfJourneysStarting());
            stationDto.setNumOfJourneysEnding(statistics.getNumOfJourneysEnding());
            stationDto.setAverageDistanceOfJourneys(statistics.getAverageDistanceOfJourneys());
            stationDto.setAverageDurationOfJourneys((int) Math.round(statistics.getAverageDurationOfJourneys()));
            if (statistics.getTopDestinationIds() != null) {
                stationDto.setTopDestinations(getTopDestinations(statistics));
            }
        }
        return stationDto;
    }

    private List<TopDestinationPair> getTopDestinations(StationStatistics statistics) {
        Map<Integer, Long> topDestinations = statistics.getTopDestinationIds();
        List<StationDto> topDestinationStations = getStationsByIds(topDestinations.keySet());
        return topDestinationStations
                .stream()
                .map(station -> new TopDestinationPair(station, topDestinations.get(station.getId()).intValue()))
                .toList();
    }
}

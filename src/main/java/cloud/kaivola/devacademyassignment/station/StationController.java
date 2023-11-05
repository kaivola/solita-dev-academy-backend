package cloud.kaivola.devacademyassignment.station;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping(path = "/stations")
    public ResponseEntity<List<StationDto>> getStations() {
        List<StationDto> stations = stationService.getStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    @GetMapping(path = "/stations/{id}")
    public ResponseEntity<StationDto> getStation(@PathVariable Integer id) {
        StationDto station = stationService.getStationById(id);
        return new ResponseEntity<>(station, HttpStatus.OK);
    }
}

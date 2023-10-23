package cloud.kaivola.devacademyassignment.station;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping(path = "/stations")
    public ResponseEntity<Page<Station>> getStations(@RequestParam Optional<Integer> page) {
        Page<Station> stations = stationService.getStations(page.orElse(0));
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
}

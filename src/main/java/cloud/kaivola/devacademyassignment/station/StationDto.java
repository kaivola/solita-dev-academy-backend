package cloud.kaivola.devacademyassignment.station;

public record StationDto(
        Integer id,
        String name,
        String address,
        String coordinateX,
        String coordinateY,
        Integer numOfJourneysStarting,
        Integer numOfJourneysEnding,
        String averageDistanceOfJourneys,
        Integer averageDurationOfJourneys) {
}

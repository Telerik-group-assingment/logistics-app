package logisticsapp.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Location {

    private LocalDateTime departureTime;
    private LocalDateTime expectedArrivalTIme;


    public Location(LocalDateTime departureTime, LocalDateTime expectedArrivalTIme) {
        this.departureTime = departureTime;
        this.expectedArrivalTIme = expectedArrivalTIme;
    }


}

package logisticsapp.models;

import java.time.LocalTime;

public class Location {

    private LocalTime departureTime;
    private LocalTime expectedArrivalTIme;

    public Location(LocalTime departureTime, LocalTime expectedArrivalTIme) {
        this.departureTime = departureTime;
        this.expectedArrivalTIme = expectedArrivalTIme;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }

    //setter - expectedArrivalTime
}

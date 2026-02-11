package logisticsapp.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Location {

    private static final int AVERAGE_SPEED = 87;

    private String city;
    private LocalDateTime expectedArrivalTime;

    public Location(String name) {
        this.city = name;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(){
        this.expectedArrivalTime = LocalDateTime.now();
    }

    public void setExpectedArrivalTime(LocalDateTime time) {
        this.expectedArrivalTime = time;
    }

    public String getFormattedExpectedArrivalTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMM d HH:mm");
        return expectedArrivalTime.format(formatter);
    }

    //public static void calculateExpectedTimeBasedOnDistance(Location startLocation, Location endLocation) {
    //Integer distance = getDistance(startlocation.getCity(), endLocation.getCity());
    //Integer travelTimeHours = distance/87;
    //LocalTime expectedArrivalTime = startLocation.getDepartureTime().plusHours(travelTimeHours);

    //long travelHours = distanceKm / speedKmPerHour;
    //Duration travelDuration = Duration.ofHours(travelHours);

    //LocalDateTime arrivalTime = departureTime.plus(travelDuration);

//    static {
//        add("SYD");
//        add("MEL");
//        add("ADL");
//        add("ASP");
//        add("BRI");
//        add("DAR");
//        add("PER");
//    }
//
//    private static void add(String locationName){
//        cities.add(locationName);
//    }

}
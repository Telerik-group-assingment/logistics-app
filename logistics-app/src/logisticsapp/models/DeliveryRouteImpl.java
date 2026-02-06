package logisticsapp.models;

import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.contracts.DeliveryRoute;
import logisticsapp.utils.ValidationHelpers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteImpl implements DeliveryRoute {

    private static final String INVALID_LOCATIONS_COUNT_MESSAGE = "Locations can't be less than 2";

    private int id;
    private List<Location> locations;
    private LocalDateTime departureTime;

    //locations to be implemented

    public DeliveryRouteImpl(int id, List<Location> locations) {
        setId(id);
        this.locations = new ArrayList<>();
        setLocations(locations);
    }

    public void startRoute() {
        this.locations.get(0).setExpectedArrivalTime();
//        System.out.println(locations.get(0).getFormattedExpectedArrivalTime());

        for (int i = 1; i < locations.size(); i++) {
            int distance = Distances.getDistance(locations.get(i - 1).getCity(), locations.get(i).getCity());
            int travelTime = distance / 87;
            locations.get(i)
                    .setExpectedArrivalTime(locations.get(i - 1).getExpectedArrivalTime().plusHours(travelTime));

//            System.out.println(locations.get(i).getFormattedExpectedArrivalTime());
        }
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setLocations(List<Location> deliveryLocations) {
        if(deliveryLocations.size() < 2){
            throw new InvalidInput(INVALID_LOCATIONS_COUNT_MESSAGE);
        }

        locations.addAll(deliveryLocations);
    }


    @Override
    public int getID() {
        return id;
    }

    //to be implemented - searchRoute(Location starLocation, Location endLocation)
    @Override
    public DeliveryRoute searchRoute() {
        return null;
    }

    @Override
    public String print() {
        return String.format("Delivery route%n" +
                        "Start location: %s%n",
                "End location: %s"); // TO BE IMPLEMENTED
    }
}

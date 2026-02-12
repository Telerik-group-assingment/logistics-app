package logisticsapp.models;

import logisticsapp.exceptions.IllegalOperation;
import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.contracts.DeliveryRoute;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteImpl implements DeliveryRoute {

    private static final String INVALID_LOCATIONS_COUNT_MESSAGE = "Locations can't be less than 2";

    private int id;
    private List<Location> locations;
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime departureTime;
    private TruckImpl truck;

    //locations to be implemented

    public DeliveryRouteImpl(int id, List<Location> locations) {
        setId(id);
        this.locations = new ArrayList<>();
        setLocations(locations);
        this.startLocation = locations.get(0);
        this.endLocation = locations.get(locations.size() - 1);
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

    public void assignTruck(TruckImpl truck) {
        if (this.truck != null) {
            throw new IllegalOperation("Route already has a truck");
        }
        this.truck = truck;
        truck.markAsAssigned(this);
    }


    @Override
    public int getID() {
        return id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route ").append(id).append(" From ").append(this.startLocation.getCity()).append(" To ")
                .append(this.endLocation.getCity())
                .append(" | Truck: ").append(truck != null ? truck.getID() : "none")
                .append(this.truck.getTruckBrand()).append(" ").append(this.truck.getCapacity())
                .append("\nPackages: ");

        if (truck != null && !truck.getDeliveryPackages().isEmpty()) {
            for (DeliveryPackageImpl p : truck.getDeliveryPackages()) {
                sb.append(p.getID()).append(" ");
            }
        } else {
            sb.append("none");
        }

        return sb.toString().trim();
    }
}

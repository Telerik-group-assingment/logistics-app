package logisticsapp.models;

import logisticsapp.models.contracts.DeliveryPackage;
import logisticsapp.models.contracts.DeliveryRoute;
import logisticsapp.models.contracts.Truck;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteImpl implements DeliveryRoute {

    private int id;
    private final List<DeliveryPackage> deliveryPackages;
    private final List<Location> locations;


    public DeliveryRouteImpl(int id, List<Location> locations) {
        setId(id);
        deliveryPackages = new ArrayList<>();
        this.locations = locations;
    }


    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public LocalTime getDepartureTime() {
        return getLocations().getFirst().getDepartureTime();
    }


    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(Location location1, Location location2) {
        locations.add(location1);
        locations.add(location2);
        // logic to calculate arrival time based on location's departure time, distance and average speed per km
    }

    @Override
    public void addPackage(DeliveryPackageImpl deliveryPackage) {
        deliveryPackages.add(deliveryPackage);
    }


    @Override
    public String print() {
        return String.format("Delivery route%n" +
                            "Id: %d" +
                            "Start location: %s%n",
                            "End location: %s", getID(), getLocations().getFirst(), getLocations().getLast());
    }
}

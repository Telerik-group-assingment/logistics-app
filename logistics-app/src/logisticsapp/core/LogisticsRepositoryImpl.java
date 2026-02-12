package logisticsapp.core;

import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.exceptions.IllegalOperation;
import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.*;
import logisticsapp.models.enums.State;
import logisticsapp.models.enums.TruckBrand;

import java.time.LocalDateTime;
import java.util.*;

public class LogisticsRepositoryImpl implements LogisticsRepository {

    private int nextTruckId;
    private int nextCustomerId;
    private int nextDeliveryRouteId;
    private int nextDeliveryPackageId;


    private final List<Customer> customers = new ArrayList<>();
    private final List<TruckImpl> trucks = new ArrayList<>();
    private final List<DeliveryRouteImpl> deliveryRoutes = new ArrayList<>();
    private final List<Location> locations = new ArrayList<>();
    private final List<DeliveryPackageImpl> packages = new ArrayList<>();


    public LogisticsRepositoryImpl() {
        nextTruckId = 0;
        nextCustomerId = 0;
        nextDeliveryRouteId = 0;
    }


    @Override
    public TruckImpl findTruckById(int id) {
        return this.trucks.stream().filter(t -> t.getID() == id).findFirst().orElseThrow();
    }


    @Override
    public List<TruckImpl> getTrucks() {
        return Collections.unmodifiableList(trucks);
    }

    @Override
    public Customer findCustomerById(int id) {
        return this.customers.stream().filter(c -> c.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public Customer createCustomer(String firstName, String secondName, String phoneNum) {

        if (this.customers.stream().anyMatch(c -> c.getPhoneNum().equals(phoneNum))) {
            throw new InvalidInput("Customer with that phoneNumber already exists! ");
        }

        Customer customer = new Customer(++nextCustomerId, firstName, secondName, phoneNum);
        this.customers.add(customer);
        return customer;
    }

    @Override
    public DeliveryRouteImpl createDeliveryRoute(List<Location> deliveryLocations) {

        boolean exists = deliveryRoutes.stream()
                .anyMatch(r -> {
                    List<String> existingCities = r.getLocations().stream()
                            .map(Location::getCity)
                            .toList();

                    List<String> newCities = deliveryLocations.stream()
                            .map(Location::getCity)
                            .toList();

                    return existingCities.equals(newCities);
                });

        if (exists) {
            throw new IllegalOperation("You are trying to create a route that already exists");
        }

        DeliveryRouteImpl deliveryRoute = new DeliveryRouteImpl(++nextDeliveryRouteId, deliveryLocations);
        this.deliveryRoutes.add(deliveryRoute);

        return deliveryRoute;
    }

    public DeliveryPackageImpl getPackageById(int id) {
        return packages.stream()
                .filter(p -> p.getID() == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Package with ID " + id + " not found"));
    }

    @Override
    public DeliveryPackageImpl createDeliveryPackage(double weight) {

        DeliveryPackageImpl deliveryPackage = new DeliveryPackageImpl(++nextDeliveryPackageId, weight);

        this.packages.add(deliveryPackage);

        return deliveryPackage;
    }


    public List<DeliveryRouteImpl> searchRoutes(Location startLocation, Location endLocation) {

        return deliveryRoutes.stream()
                .filter(r -> r.getStartLocation().getCity().equals(startLocation.getCity())
                        && r.getEndLocation().getCity().equals(endLocation.getCity()))
                .toList();

//        return deliveryRoutes
//                .stream()
//                .filter(r -> r.getLocations().contains(startLocation) &&
//                        r.getLocations().contains(endLocation)).toList();
    }


    public List<DeliveryRouteImpl> getDeliveryRoutes() {
        return Collections.unmodifiableList(deliveryRoutes);
    }

    @Override
    public Location createLocation(String city) {

        boolean exists = locations
                .stream()
                .anyMatch(l -> l.getCity().equals(city));

        if(exists){
            throw new IllegalOperation("You are trying to create a location that already exists");
        }

        Location location = new Location(city);

        locations.add(location);

        return location;
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    public TruckImpl getTruckById(int id) {
        return trucks.stream()
                .filter(t -> t.getID() == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Truck with ID " + id + " not found"));
    }

    public DeliveryRouteImpl getRouteById(int id) {
        return deliveryRoutes.stream()
                .filter(r -> r.getID() == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Route with ID " + id + " not found"));
    }


    @Override
    public TruckImpl createTruck(TruckBrand truckBrand) {

        int capacity = 0;
        int maxRange = 0;

        switch (truckBrand.toString()) {

            case "Scania":

                capacity = 42000;
                maxRange = 8000;

                break;
            case "Man":

                capacity = 37000;
                maxRange = 10000;
                break;
            case "Actros":

                capacity = 26000;
                maxRange = 13000;

                break;
        }

        TruckImpl truck = new TruckImpl(++nextTruckId, capacity, maxRange, truckBrand);
        this.trucks.add(truck);
        return truck;
    }


}

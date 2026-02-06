package logisticsapp.core;

import logisticsapp.core.contracts.LogisticsRepository;
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
    private final Map<String,Map<String,Integer>> distanceMap = new HashMap<>();
    private final List<Location> locations = new ArrayList<>();


    public LogisticsRepositoryImpl(){
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

        if(this.customers.stream().anyMatch(c -> c.getPhoneNum().equals(phoneNum))){
            throw new InvalidInput("Customer with that phoneNumber already exists! ");
        }

        Customer customer = new Customer(++nextCustomerId,firstName,secondName,phoneNum);
        this.customers.add(customer);
        return customer;
    }

    @Override
    public DeliveryRouteImpl createDeliveryRoute(List<Location> locations) {

       DeliveryRouteImpl deliveryRoute = new DeliveryRouteImpl(++nextDeliveryRouteId,locations);

       this.deliveryRoutes.add(deliveryRoute);

        return deliveryRoute;
    }

    @Override
    public DeliveryPackageImpl createDeliveryPackage(double weight, State state) {

        DeliveryPackageImpl deliveryPackage = new DeliveryPackageImpl(++nextDeliveryPackageId,weight,state);

//        TODO

        return deliveryPackage;
    }

    @Override
    public Location createLocation(String city) {
        Location location = new Location(city);

        locations.add(location);

        return location;
    }

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public TruckImpl createTruck(TruckBrand truckBrand) {

        int capacity = 0;
        int maxRange = 0;

        switch (truckBrand.toString()){

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

        TruckImpl truck = new TruckImpl(++nextTruckId,capacity,maxRange,truckBrand);
        this.trucks.add(truck);
        return truck;
    }





}

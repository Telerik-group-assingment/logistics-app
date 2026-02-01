package logisticsapp.models;

import logisticsapp.models.contracts.DeliveryPackage;
import logisticsapp.models.contracts.DeliveryRoute;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteImpl implements DeliveryRoute {

    private int id;
    private List<DeliveryPackage> deliveryPackages;
    //locations to be implemented

    public DeliveryRouteImpl(int id) {
        setId(id);
        deliveryPackages = new ArrayList<>();
    }


    private void setId(int id) {
        this.id = id;
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


    public void assignPackage(DeliveryPackage deliveryPackage) {
        deliveryPackages.add(deliveryPackage);
    }

    @Override
    public String print() {
        return String.format("Delivery route%n" +
                            "Start location: %s%n",
                            "End location: %s"); // TO BE IMPLEMENTED
    }
}

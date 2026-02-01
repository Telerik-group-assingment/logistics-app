package logisticsapp.models;

import logisticsapp.models.contracts.DeliveryRoute;

public class DeliveryRouteImpl implements DeliveryRoute {

    private int id;
    //locations to be implemented

    public DeliveryRouteImpl(int id) {
        setId(id);
    }


    //to be implemented - searchRoute(Location starLocation, Location endLocation)
    @Override
    public DeliveryRoute searchRoute() {
        return null;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String print() {
        return String.format("Delivery route%n" +
                            "Start location: %s%n",
                            "End location: %s"); // TO BE IMPLEMENTED
    }
}

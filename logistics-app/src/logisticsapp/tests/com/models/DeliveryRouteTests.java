package com.models;

import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;
import logisticsapp.models.enums.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRouteTests {

    DeliveryRouteImpl deliveryRoute;
    Location location1 = new Location("SYD");
    Location location2 = new Location("MEL");
    private List<Location> locations = new ArrayList<>();

    @BeforeEach
    public void init() {
        deliveryRoute = new DeliveryRouteImpl(1,locations);
    }

    // public DeliveryRouteImpl(int id, List<Location> locations) {
    //        setId(id);
    //        this.locations = new ArrayList<>();
    //        setLocations(locations);
    //    }

    @Test
    public void deliveryRouteConstructor_ShouldSetLocationsCorrectly(){
        locations.add(location1);
        locations.add(location2);
        Assertions.assertEquals(2,deliveryRoute.getLocations().size());
    }




}

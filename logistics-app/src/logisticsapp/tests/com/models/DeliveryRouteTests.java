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



    @BeforeEach
    public void init() {
        List<Location> locations = new ArrayList<>();
        Location location1 = new Location("SYD");
        Location location2 = new Location("MEL");

        locations.add(location1);
        locations.add(location2);

        deliveryRoute = new DeliveryRouteImpl(1,locations);

    }

    @Test
    public void deliveryRouteConstructor_ShouldSetLocationsCorrectly(){
        Assertions.assertEquals(2,deliveryRoute.getLocations().size());
    }




}

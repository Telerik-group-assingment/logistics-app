package com.models;

import logisticsapp.exceptions.IllegalOperation;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;
import logisticsapp.models.TruckImpl;
import logisticsapp.models.contracts.Truck;
import logisticsapp.models.enums.TruckBrand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Test
    public void start_Route_Should_Set_First_Location_Expected_Arrival_Time_To_Now() {
        deliveryRoute.startRoute();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMM d HH:mm");
        Assertions.assertEquals(LocalDateTime.now().format(formatter), deliveryRoute.getStartLocation().getExpectedArrivalTime().format(formatter));
    }

    @Test
    public void start_Route_Should_Calculate_Expected_Arrival_Time_Correctly() {
        deliveryRoute.startRoute();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMM d HH:mm");
        Assertions.assertEquals(LocalDateTime.now().plusHours(10).format(formatter), deliveryRoute.getLocations().get(1).getFormattedExpectedArrivalTime());

    }

    @Test
    public void assign_Truck_Should_Throw_Exception_When_Truck_Already_Set() {
        TruckImpl truck = new TruckImpl(1, 42000, 8000, TruckBrand.SCANIA);
        deliveryRoute.assignTruck(truck);

        Assertions.assertThrows(IllegalOperation.class, () -> deliveryRoute.assignTruck(truck));
    }

    @Test
    public void assign_Truck_Should_Set_Truck_Correctly() {
        TruckImpl truck = new TruckImpl(1, 42000, 8000, TruckBrand.SCANIA);
        deliveryRoute.assignTruck(truck);

        Assertions.assertEquals(truck, deliveryRoute.getTruck());
    }
}

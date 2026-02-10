package com.models;

import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.models.TruckImpl;
import logisticsapp.models.enums.State;
import logisticsapp.models.enums.TruckBrand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TruckTests {

    @Test
    public void Constructor_ShouldSetCapacityValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(20, truck.getCapacity());
    }

    @Test
    public void Constructor_ShouldSetMaxRangeValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(500, truck.getMaxRange());
    }

    @Test
    public void Constructor_ShouldSetTruckBrandValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(TruckBrand.SCANIA, truck.getTruckBrand());
    }

    @Test
    public void AssignPackeToTruck_ShouldWorkCorrectly() {
        TruckImpl truck = new TruckImpl(1, 200, 500, TruckBrand.SCANIA);
        DeliveryPackageImpl deliveryPackage = new DeliveryPackageImpl(1,30, State.NOT_ASSIGNED);

        truck.assignPackageToTruck(deliveryPackage);

        int currPackagedId = truck.getDeliveryPackages().get(0).getID();

        Assertions.assertEquals(currPackagedId,deliveryPackage.getID());

    }


}

package com.models;

import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.models.TruckImpl;
import logisticsapp.models.enums.TruckBrand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TruckTests {

    @Test
    public void constructor_shouldSetCapacityValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(20, truck.getCapacity());
    }

    @Test
    public void constructor_shouldSetMaxRangeValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(500, truck.getMaxRange());
    }

    @Test
    public void constructor_shouldSetTruckBrandValueCorrectly() {
        TruckImpl truck = new TruckImpl(1, 20, 500, TruckBrand.SCANIA);

        Assertions.assertEquals(TruckBrand.SCANIA, truck.getTruckBrand());
    }

    @Test
    public void assignPackeToTruck_shouldWorkCorrectly() {
        TruckImpl truck = new TruckImpl(1, 200, 500, TruckBrand.SCANIA);
        DeliveryPackageImpl deliveryPackage = new DeliveryPackageImpl(1,30);

        truck.assignPackageToTruck(deliveryPackage);

        int currPackagedId = truck.getDeliveryPackages().get(0).getID();

        Assertions.assertEquals(currPackagedId,deliveryPackage.getID());

    }


}

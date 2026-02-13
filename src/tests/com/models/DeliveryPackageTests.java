package com.models;

import logisticsapp.models.CustomerImpl;
import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.models.enums.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeliveryPackageTests {

    DeliveryPackageImpl deliveryPackage;

    @BeforeEach
    public void innit() {
        deliveryPackage = new DeliveryPackageImpl(1, 20.5);
    }

    @Test
    public void constructor_Should_Set_Weight_Correctly() {
        Assertions.assertEquals(20.5, deliveryPackage.getWeight());
    }

    @Test
    public void constructor_Should_Throw_Exception_When_Weight_Negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DeliveryPackageImpl(2, -23.5));
    }

    @Test
    public void constructor_Should_Set_To_Unassigned() {
        Assertions.assertEquals(State.NOT_ASSIGNED, deliveryPackage.getState());
    }

    @Test
    public void set_Assigned_Should_Change_State() {
        deliveryPackage.setAssigned();
        Assertions.assertEquals(State.ASSIGNED, deliveryPackage.getState());
    }

    @Test
    public void set_Customer_Should_Work_Correctly() {
        CustomerImpl customer = new CustomerImpl(1, "Pesho", "Yordanov", "0891234567");
        deliveryPackage.setCustomer(customer);
        Assertions.assertEquals(customer, deliveryPackage.getCustomer());
    }
}

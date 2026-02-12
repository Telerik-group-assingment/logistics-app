package com.models;

import logisticsapp.commands.creation.CreateCustomerCommand;
import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTests {

    Customer customer;

    @BeforeEach
    public void init() {
        customer = new Customer(1, "tomi", "babunski", "1234567899");
    }


    @Test
    public void customerConstructor_shouldSetFirstNameCorrectly() {
        Assertions.assertEquals("tomi", customer.getFirstName());
    }

    @Test
    public void customerConstructor_shouldSetLastNameCorrectly() {
        Assertions.assertEquals("babunski", customer.getLastName());
    }

    @Test
    public void customerConstructor_shouldSetPhoneNumberCorrectly() {
        Assertions.assertEquals("1234567899", customer.getPhoneNum());
    }

    @Test
    public void customerConstructor_shouldInitializePackageCollectionCorrectly() {
        Assertions.assertEquals(0, customer.getPackageIds().size());
    }

    @Test
    public void customer_shouldThrowException_WhenFirstNameIsNotCorrect() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer(1, "s", "jogurt",
                "1234567899"));
    }

    @Test
    public void customer_shouldThrowException_WhenLastNameIsNotCorrect() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer(1, "sandi", "p",
                "1234567899"));
    }

    @Test
    public void customer_shouldThrowException_WhenPhoneNumIsNotCorrect() {
        Assertions.assertThrows(InvalidInput.class, () -> new Customer(1, "sponge", "bobbbbbb",
                "123456789"));
    }

}

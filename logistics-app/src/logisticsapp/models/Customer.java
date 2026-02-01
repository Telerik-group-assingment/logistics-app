package logisticsapp.models;

import logisticsapp.exceptions.InvalidInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private final static int MIN_NAMELENGTH = 2;
    private final static int MAX_NAMELENGTH = 30;

    private final List<Integer> packageIds;

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNum;


    public Customer(int id, String firstName, String lastName, String phoneNum) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNum(phoneNum);
        packageIds = new ArrayList<>();
    }

    public List<Integer> getPackageIds() {
        return Collections.unmodifiableList(packageIds);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < MIN_NAMELENGTH || firstName.length() > MAX_NAMELENGTH) {
            throw new InvalidInput(String.format("Name must be between %d and %d characters",
                    MIN_NAMELENGTH, MAX_NAMELENGTH));
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < MIN_NAMELENGTH || lastName.length() > MAX_NAMELENGTH) {
            throw new InvalidInput(String.format("Name must be between %d and %d characters",
                    MIN_NAMELENGTH, MAX_NAMELENGTH));
        }
        this.lastName = lastName;
    }

    public void setPhoneNum(String phoneNum) {
        if (phoneNum.length() != 10) {
            throw new InvalidInput("Invalid phone number");
        }
        this.phoneNum = phoneNum;
    }


}

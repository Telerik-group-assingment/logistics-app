package logisticsapp.models;

import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.contracts.Customer;
import logisticsapp.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerImpl implements Customer {

    private static final String INVALID_NAME_ERROR_MESSAGE = "%s name must be between %d and %d characters.";

    private final static int MIN_NAMELENGTH = 2;
    private final static int MAX_NAMELENGTH = 30;

    private final List<Integer> packageIds;

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNum;


    public CustomerImpl(int id, String firstName, String lastName, String phoneNum) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNum(phoneNum);
        packageIds = new ArrayList<>();
    }

    public List<Integer> getPackageIds() {
        return Collections.unmodifiableList(packageIds);
    }

    @Override
    public int getID() {
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

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        ValidationHelpers.validateStringLength(firstName, MIN_NAMELENGTH, MAX_NAMELENGTH,
                String.format(INVALID_NAME_ERROR_MESSAGE, "First", MIN_NAMELENGTH, MAX_NAMELENGTH));
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        ValidationHelpers.validateStringLength(lastName, MIN_NAMELENGTH, MAX_NAMELENGTH,
                String.format(INVALID_NAME_ERROR_MESSAGE, "Last", MIN_NAMELENGTH, MAX_NAMELENGTH));
        this.lastName = lastName;
    }

    private void setPhoneNum(String phoneNum) {
        if (phoneNum.length() != 10) {
            throw new InvalidInput("Invalid phone number");
        }
        this.phoneNum = phoneNum;
    }


    @Override
    public String print() {
        return String.format("Customer details:%n" +
                            "First name: %s%n" +
                            "Last name: %s%n" +
                            "Phone number: %s", getFirstName(), getLastName(), getPhoneNum());
    }
}

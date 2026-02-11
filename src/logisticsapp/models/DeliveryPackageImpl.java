package logisticsapp.models;

import logisticsapp.models.contracts.DeliveryPackage;
import logisticsapp.models.enums.State;
import logisticsapp.utils.ValidationHelpers;

public class DeliveryPackageImpl implements DeliveryPackage {

    private static final String WEIGHT_ERROR_MESSAGE = "Weight cannot be negative!";

    private int id;
    private double weight;
//    private Customer customer;
    // Locations to be implemented
    private State state;

    public DeliveryPackageImpl(int id, double weight,State state) {
        setId(id);
        setWeight(weight);
        this.state = state;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        ValidationHelpers.validateNumberNotNegative(weight, WEIGHT_ERROR_MESSAGE);
        this.weight = weight;
    }



    public State getState() {
        return this.state;
    }

    private void setState(State state) {
        this.state = state;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String print() {
        return String.format("Delivery package%n" +
                            "Weight: %.2f%n",
                            "State: %s",
                            "Contact information: %s", getWeight(), getState(), getClass());
    }
}

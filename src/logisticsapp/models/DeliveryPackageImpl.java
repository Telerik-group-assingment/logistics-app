package logisticsapp.models;

import logisticsapp.models.contracts.Customer;
import logisticsapp.models.contracts.DeliveryPackage;
import logisticsapp.models.enums.State;
import logisticsapp.utils.ValidationHelpers;

public class DeliveryPackageImpl implements DeliveryPackage {

    private static final String WEIGHT_ERROR_MESSAGE = "Weight cannot be negative!";

    private int id;
    private double weight;
    private Customer customer;
    private State state;

    public DeliveryPackageImpl(int id, double weight) {
        setId(id);
        setWeight(weight);
        this.state = State.NOT_ASSIGNED;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public State getState() {
        return this.state;
    }

    protected void setAssigned() {
        this.state = State.ASSIGNED;
    }


    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Delivery package:").append("ID: ").append(getID()).append("\n").append("Weight: ").append(getWeight()).append("\n")
                .append("State: ").append(getState())
                .append("\n").append(this.customer != null ? this.customer.print() : "No customer information found.");
        return stringBuilder.toString();
    }
}

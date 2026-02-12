package logisticsapp.models;

import logisticsapp.exceptions.IllegalOperation;
import logisticsapp.models.contracts.Truck;
import logisticsapp.models.enums.TruckBrand;
import logisticsapp.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TruckImpl implements Truck {

    public static final String ERROR_CAPACITY_CANNOT_BE_NEGATIVE = "No capacity in truck!";
    private int id;
    private double capacity;
    private int maxRange;
    private TruckBrand truckBrand;
    private List<DeliveryPackageImpl> deliveryPackages;
    private boolean assigned;
    private DeliveryRouteImpl route;

    public TruckImpl(int id, int capacity, int maxRange, TruckBrand truckBrand) {
        setId(id);
        setCapacity(capacity);
        setMaxRange(maxRange);
        setTruckBrand(truckBrand);
        deliveryPackages = new ArrayList<>();
        assigned = false;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMaxRange() {
        return maxRange;
    }

    private void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public TruckBrand getTruckBrand() {
        return truckBrand;
    }

    private void setTruckBrand(TruckBrand truckBrand) {
        this.truckBrand = truckBrand;
    }

    public void assignPackageToTruck(DeliveryPackageImpl deliveryPackage) {
        ValidationHelpers.validateNumberNotNegative(capacity - deliveryPackage.getWeight(),
                ERROR_CAPACITY_CANNOT_BE_NEGATIVE);

        if (deliveryPackages.contains(deliveryPackage)) {
            throw new IllegalOperation("Package already loaded in this truck");
        }

        deliveryPackages.add(deliveryPackage);
        capacity -= deliveryPackage.getWeight();
    }

    public boolean isAssigned() {
        return assigned;
    }

    void markAsAssigned(DeliveryRouteImpl route) {
        this.assigned = true;
        this.route = route;
    }

    public List<DeliveryPackageImpl> getDeliveryPackages() {
        return new ArrayList<>(deliveryPackages);
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public String print() {
        return String.format("Truck info:%n" +
                        "Capacity: %d",
                "Max range: %d",
                "Truck brand: %s", getCapacity(), getMaxRange(), getTruckBrand());
    }
}

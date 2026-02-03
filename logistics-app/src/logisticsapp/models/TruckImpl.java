package logisticsapp.models;

import logisticsapp.models.contracts.Truck;
import logisticsapp.models.enums.TruckBrand;

public class TruckImpl implements Truck {

    private int id;
    private int capacity;
    private int maxRange;
    private TruckBrand truckBrand;
    // private DeliveryRoute

    public TruckImpl(int id, int capacity, int maxRange, TruckBrand truckBrand) {
        setId(id);
        setCapacity(capacity);
        setMaxRange(maxRange);
        setTruckBrand(truckBrand);
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
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

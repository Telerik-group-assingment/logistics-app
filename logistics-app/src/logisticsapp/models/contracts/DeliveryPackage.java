package logisticsapp.models.contracts;

import logisticsapp.models.enums.State;

public interface DeliveryPackage extends Printable, Identifiable {

    public State getState();

}

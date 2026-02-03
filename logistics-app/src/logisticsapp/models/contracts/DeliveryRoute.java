package logisticsapp.models.contracts;


import logisticsapp.models.DeliveryPackageImpl;

import java.time.LocalTime;

public interface DeliveryRoute extends Printable, Identifiable {

    LocalTime getDepartureTime();

    void addPackage(DeliveryPackageImpl deliveryPackage);

}

package logisticsapp.core.contracts;

import logisticsapp.models.*;
import logisticsapp.models.enums.TruckBrand;

import java.util.List;

public interface LogisticsRepository {


    TruckImpl  findTruckById(int id);

    CustomerImpl findCustomerById(int id);

    List<TruckImpl> getTrucks();

    List<Location> getLocations();


    CustomerImpl createCustomer(String firstName, String secondName, String PhoneNum);

    DeliveryRouteImpl createDeliveryRoute(List<Location> locations);

    DeliveryPackageImpl createDeliveryPackage(double weight);

    Location createLocation(String city);

    TruckImpl createTruck(TruckBrand truckBrand);


    TruckImpl getTruckById(int truckId);

    DeliveryRouteImpl getRouteById(int routeId);

    DeliveryPackageImpl getPackageById(int packageId);

    List<DeliveryRouteImpl> searchRoutes(Location startLocation, Location endLocation);

    List<DeliveryRouteImpl> getDeliveryRoutes();

    List<DeliveryPackageImpl> getUnassignedPackages();

}




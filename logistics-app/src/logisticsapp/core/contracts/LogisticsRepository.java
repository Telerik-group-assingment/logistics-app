package logisticsapp.core.contracts;

import logisticsapp.models.*;
import logisticsapp.models.contracts.Identifiable;
import logisticsapp.models.enums.State;
import logisticsapp.models.enums.TruckBrand;

import java.time.LocalDateTime;
import java.util.List;

public interface LogisticsRepository {


    TruckImpl  findTruckById(int id);

    Customer findCustomerById(int id);

    List<TruckImpl> getTrucks();

    List<Location> getLocations();


    Customer createCustomer(String firstName,String secondName,String PhoneNum);

    DeliveryRouteImpl createDeliveryRoute(List<Location> locations);

    DeliveryPackageImpl createDeliveryPackage(double weight, State state);

    Location createLocation(String city);

    TruckImpl createTruck(TruckBrand truckBrand);


    }




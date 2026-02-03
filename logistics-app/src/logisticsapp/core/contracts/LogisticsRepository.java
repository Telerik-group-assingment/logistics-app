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


    Customer createCustomer(String firstName,String secondName,String PhoneNum);

    DeliveryRouteImpl createDeliveryRoute();

    DeliveryPackageImpl createDeliveryPackage(double weight, State state);

    Location createLocation(LocalDateTime departureTime,LocalDateTime expectedArrivalTime);

    TruckImpl createTruck(TruckBrand truckBrand);


    }




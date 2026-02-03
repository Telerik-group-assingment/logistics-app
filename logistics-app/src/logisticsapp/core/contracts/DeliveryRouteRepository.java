package logisticsapp.core.contracts;

import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface DeliveryRouteRepository {

    List<DeliveryRouteImpl> getRoutes();

    Optional<DeliveryRouteImpl> findRouteById(int id);

    List<DeliveryRouteImpl> searchRoutes(Location startLocation, Location endLocation);

    DeliveryRouteImpl createDeliveryRoute(List<Location> locations);

}

package logisticsapp.core.repositories;

import logisticsapp.core.contracts.DeliveryRouteRepository;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeliveryRouteRepositoryImpl implements DeliveryRouteRepository {

    private int nextId;

    private final List<DeliveryRouteImpl> routes = new ArrayList<>();

    public DeliveryRouteRepositoryImpl() {
        nextId++;
    }


    @Override
    public List<DeliveryRouteImpl> getRoutes() {
        return new ArrayList<>(routes);
    }

    @Override
    public Optional<DeliveryRouteImpl> findRouteById(int id) {
        return routes.stream()
                .filter(r -> r.getID() == id)
                .findFirst();
    }


    @Override
    public DeliveryRouteImpl createDeliveryRoute(List<Location> locations) {
        return new DeliveryRouteImpl(nextId++, locations);
    }

    @Override
    public List<DeliveryRouteImpl> searchRoutes(Location startLocation, Location endLocation) {
        return routes
                .stream()
                .filter(r -> r.getLocations().contains(startLocation) && r.getLocations().contains(endLocation)).toList();
    }
}

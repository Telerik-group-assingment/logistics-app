package logisticsapp.commands.assign;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.TruckImpl;
import logisticsapp.models.contracts.Truck;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class AssignTruckCommand implements Command {

    private static final int EXPECTED_ARGUMENTS = 2;

    private final LogisticsRepository repository;

    public AssignTruckCommand(LogisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_ARGUMENTS);

        int truckId = Integer.parseInt(parameters.get(0));
        int routeId = Integer.parseInt(parameters.get(1));

        TruckImpl truck = repository.getTruckById(truckId);
        DeliveryRouteImpl route = repository.getRouteById(routeId);

        route.assignTruck(truck);

        return String.format(
                "Truck %d successfully assigned to route %d",
                truckId, routeId);
    }
}

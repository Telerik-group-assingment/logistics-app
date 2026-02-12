package logisticsapp.commands.start;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.utils.ParsingHelpers;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class StartDeliveryRouteCommand implements Command {

    private static final int EXPECTED_ARGUMENTS = 1;
    private LogisticsRepository logisticsRepository;

    public StartDeliveryRouteCommand(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_ARGUMENTS);

        int routeId = ParsingHelpers.tryParseInteger(parameters.get(0));

        DeliveryRouteImpl route = logisticsRepository.getRouteById(routeId);

        route.startRoute();

        return String.format("Route %d has been started successfully", routeId);
    }
}

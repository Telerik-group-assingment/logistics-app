package logisticsapp.commands.search;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class SearchRouteCommand implements Command {

    private static final int EXPECTED_ARGUMENTS = 2;

    private final LogisticsRepository logisticsRepository;

    public SearchRouteCommand(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_ARGUMENTS);

        Location startLocation = logisticsRepository.getLocations()
                .stream()
                .filter(l -> l.getCity().equals(parameters.get(0)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown location: " + parameters.get(0)));


        Location endLocation = logisticsRepository.getLocations()
                .stream()
                .filter(l -> l.getCity().equals(parameters.get(1)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown location: " + parameters.get(1)));


        List<DeliveryRouteImpl> routes =
                logisticsRepository.searchRoutes(startLocation, endLocation);

        if (routes.isEmpty()) {
            throw new IllegalArgumentException(
                    "No routes found from " + startLocation.getCity()
                            + " to " + endLocation.getCity());
        }

        StringBuilder result = new StringBuilder();

        for (DeliveryRouteImpl route : routes) {
            result.append(route.print())
                    .append(System.lineSeparator());
        }

        return result.toString().trim();

    }

}

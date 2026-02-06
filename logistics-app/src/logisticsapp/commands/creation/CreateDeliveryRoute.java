package logisticsapp.commands.creation;

import logisticsapp.commands.CommandsConstants;
import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.DeliveryRouteImpl;
import logisticsapp.models.Location;
import logisticsapp.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class CreateDeliveryRoute implements Command {

     private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
     private static final String MIN_EXPECTED_NUMBER_OF_ARGUMENTS_MESSAGE = "Parameters must be at least 2";
     private static final String INVALID_LOCATION_MESSAGE = "Trying to add invalid location";

     private final LogisticsRepository repository;

    public CreateDeliveryRoute(LogisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        if(parameters.size() < EXPECTED_NUMBER_OF_ARGUMENTS){
            throw new InvalidInput(MIN_EXPECTED_NUMBER_OF_ARGUMENTS_MESSAGE);
        }

        List<Location> locations = repository.getLocations();

        List<Location> locationsToAddToRoute = new ArrayList<>();

        for (int i = 0; i < parameters.size(); i++) {
             Location location = new Location(parameters.get(i));

             if(locations.stream().anyMatch(l -> l.getCity().equals(location.getCity()))){
                 locationsToAddToRoute.add(location);
             }
             else{
                 throw new InvalidInput(INVALID_LOCATION_MESSAGE);
             }
        }

        DeliveryRouteImpl deliveryRoute = repository.createDeliveryRoute(locationsToAddToRoute);


        return String.format(CommandsConstants.DELIVERY_ROUTE_CREATED_MESSAGE,deliveryRoute.getID(),
                locationsToAddToRoute.get(0).getCity(),locationsToAddToRoute.get(locations.size() - 1).getCity());
    }
}

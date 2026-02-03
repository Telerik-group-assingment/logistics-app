package logisticsapp.commands.creation;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryRouteImpl;

import java.util.List;

public class CreateDeliveryRoute implements Command {

     private final LogisticsRepository repository;

    public CreateDeliveryRoute(LogisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {


        DeliveryRouteImpl deliveryRoute = repository.createDeliveryRoute();


        return "";
    }
}

package logisticsapp.commands.show;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryRouteImpl;

import java.util.List;

public class ShowRoutesCommand implements Command {

    private final LogisticsRepository repository;

    public ShowRoutesCommand(LogisticsRepository repository) {
        this.repository = repository;
    }


    @Override
    public String execute(List<String> parameters) {
        List<DeliveryRouteImpl> deliveryRoutes = repository.getDeliveryRoutes();

        if (deliveryRoutes.isEmpty()) {
            return "No routes available.";
        }

        StringBuilder sb = new StringBuilder();

        for (DeliveryRouteImpl deliveryRoute : deliveryRoutes) {
            sb.append(deliveryRoute.print()).append('\n');
        }

        return sb.toString().trim();
    }
}

package logisticsapp.commands.show;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryPackageImpl;

import java.util.List;

public class ShowUnassignedPackages implements Command {

    private final LogisticsRepository logisticsRepository;

    public ShowUnassignedPackages(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {

        List <DeliveryPackageImpl> unassignedPackages = logisticsRepository.getUnassignedPackages();

        if (unassignedPackages.isEmpty()) {
            return "There are no unassigned packages currently";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (DeliveryPackageImpl unassignedPackage : unassignedPackages) {
            stringBuilder.append(unassignedPackage.print());
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}

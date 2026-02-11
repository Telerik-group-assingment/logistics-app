package logisticsapp.commands.assign;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.models.TruckImpl;
import logisticsapp.utils.ParsingHelpers;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class AssignPackageCommand implements Command {
    private static final int EXPECTED_ARGUMENTS = 2;

    private final LogisticsRepository repository;

    public AssignPackageCommand(LogisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_ARGUMENTS);

        int packageId = ParsingHelpers.tryParseInteger(parameters.get(0));
        int truckId = ParsingHelpers.tryParseInteger(parameters.get(1));

        DeliveryPackageImpl deliveryPackage =
                repository.getPackageById(packageId);

        TruckImpl truck =
                repository.getTruckById(truckId);

        truck.assignPackageToTruck(deliveryPackage);

        return String.format(
                "Package %d successfully assigned to truck %d",
                packageId, truckId);
    }
}

package logisticsapp.commands.assign;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.CustomerImpl;
import logisticsapp.models.DeliveryPackageImpl;
import logisticsapp.utils.ParsingHelpers;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class AssignCustomerToPackageCommand implements Command {

    private static final int EXPECTED_ARGUMENTS = 2;

    private final LogisticsRepository repository;

    public AssignCustomerToPackageCommand(LogisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_ARGUMENTS);

        int customerID = ParsingHelpers.tryParseInteger(parameters.get(0));
        int packageID = ParsingHelpers.tryParseInteger(parameters.get(1));
        CustomerImpl customer = repository.findCustomerById(customerID);
        DeliveryPackageImpl deliveryPackage = repository.getPackageById(packageID);

        deliveryPackage.setCustomer(customer);

        return String.format("Customer with ID %d successfully assigned to package with ID %d.", customerID, packageID);
    }
}

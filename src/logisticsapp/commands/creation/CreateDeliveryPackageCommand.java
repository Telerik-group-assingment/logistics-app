package logisticsapp.commands.creation;

import logisticsapp.commands.CommandsConstants;
import logisticsapp.commands.contracts.Command;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.Customer;
import logisticsapp.models.contracts.DeliveryPackage;
import logisticsapp.models.enums.State;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class CreateDeliveryPackageCommand implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private final LogisticsRepository repository;


    public CreateDeliveryPackageCommand(LogisticsRepository repository){
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);

        DeliveryPackage createdDeliveryPackage = repository.createDeliveryPackage(Double.parseDouble(parameters.get(1)),State.NOT_ASSIGNED);


        return String.format(CommandsConstants.DELIVERY_PACKAGE_CREATED_MESSAGE,createdDeliveryPackage.getID());
    }
}

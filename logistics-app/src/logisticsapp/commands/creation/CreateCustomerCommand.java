package logisticsapp.commands.creation;

import logisticsapp.commands.CommandsConstants;
import logisticsapp.commands.contracts.Command;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.Customer;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class CreateCustomerCommand implements Command {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;


    private final LogisticsRepository repository;

    public CreateCustomerCommand(LogisticsRepository repository){
        this.repository = repository;
    }



    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);


        Customer createdCustomer = repository.createCustomer(parameters.get(0),parameters.get(1),parameters.get(2));


        return String.format(CommandsConstants.CUSTOMER_CREATED_MESSAGE,createdCustomer.getId());
    }
}

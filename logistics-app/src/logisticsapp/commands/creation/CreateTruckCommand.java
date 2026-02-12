package logisticsapp.commands.creation;

import logisticsapp.commands.CommandsConstants;
import logisticsapp.commands.contracts.Command;
import logisticsapp.commands.enums.CommandType;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.TruckImpl;
import logisticsapp.models.enums.TruckBrand;
import logisticsapp.utils.ParsingHelpers;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

public class CreateTruckCommand implements Command {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    private static final String INVALID_COMMAND = "Invalid truck brand";

    private LogisticsRepository logisticsRepository;

    public CreateTruckCommand(LogisticsRepository repository) {
        this.logisticsRepository = repository;
    }

    @Override
    public String execute(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);


        ParsingHelpers.tryParseEnum(parameters.get(0), TruckBrand.class,String.format(INVALID_COMMAND));

        TruckImpl createdTruck = logisticsRepository.createTruck(TruckBrand.valueOf(parameters.get(0).toUpperCase()));


        return String.format(CommandsConstants.TRUCK_CREATED_MESSAGE,parameters.get(0).toUpperCase(),createdTruck.getID());
    }
}

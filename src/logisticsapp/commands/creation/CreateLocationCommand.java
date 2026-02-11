package logisticsapp.commands.creation;

import logisticsapp.commands.contracts.Command;
import logisticsapp.commands.enums.Cities;
import logisticsapp.core.LogisticsRepositoryImpl;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.models.Location;
import logisticsapp.utils.ParsingHelpers;
import logisticsapp.utils.ValidationHelpers;

import java.util.List;

import static logisticsapp.commands.CommandsConstants.LOCATION_CREATED_MESSAGE;

public class CreateLocationCommand implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String INVALID_CITY_MESSAGE = "Invalid city";

    private LogisticsRepository logisticsRepository;

    public CreateLocationCommand(LogisticsRepository logisticsRepository){
        this.logisticsRepository = logisticsRepository;
    }


    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);

        ParsingHelpers.tryParseEnum(parameters.get(0), Cities.class,INVALID_CITY_MESSAGE);

        Location location =  logisticsRepository.createLocation(parameters.get(0));

        return String.format(LOCATION_CREATED_MESSAGE,location.getCity());
    }
}

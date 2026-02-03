package logisticsapp.core;

import logisticsapp.commands.contracts.Command;
import logisticsapp.commands.creation.CreateCustomerCommand;
import logisticsapp.commands.creation.CreateDeliveryPackageCommand;
import logisticsapp.commands.creation.CreateDeliveryRoute;
import logisticsapp.commands.creation.CreateTruckCommand;
import logisticsapp.commands.enums.CommandType;
import logisticsapp.core.contracts.CommandFactory;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.utils.ParsingHelpers;

import java.util.List;

import static logisticsapp.commands.enums.CommandType.*;

public class CommandFactoryImpl implements CommandFactory {


    private static final String INVALID_COMMAND = "Invalid command name: %s!";


    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, LogisticsRepository logisticsRepository) {

        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString, CommandType.class,String.format(INVALID_COMMAND,commandTypeAsString));


        switch (commandType) {


            case CREATECUSTOMER:
                return new CreateCustomerCommand(logisticsRepository);
            case CREATEDELIVERYPACKAGE:
                return new CreateDeliveryPackageCommand(logisticsRepository);
            case CREATEDELIVERYROUTE:
                return new CreateDeliveryRoute(logisticsRepository);
            case CREATETRUCK:
                return new CreateTruckCommand(logisticsRepository);
            case CREATELOCATION:
                return new CreateCustomerCommand(logisticsRepository);
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);

        }



    }


}

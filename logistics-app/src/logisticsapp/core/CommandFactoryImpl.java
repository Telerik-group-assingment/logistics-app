package logisticsapp.core;

import logisticsapp.commands.assign.AssignPackageCommand;
import logisticsapp.commands.assign.AssignTruckCommand;
import logisticsapp.commands.contracts.Command;
import logisticsapp.commands.creation.*;
import logisticsapp.commands.enums.CommandType;
import logisticsapp.commands.help.HelpCommand;
import logisticsapp.commands.search.SearchRouteCommand;
import logisticsapp.commands.show.ShowRoutesCommand;
import logisticsapp.commands.start.StartDeliveryRouteCommand;
import logisticsapp.core.contracts.CommandFactory;
import logisticsapp.core.contracts.LogisticsRepository;
import logisticsapp.utils.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {


    private static final String INVALID_COMMAND = "Invalid command name: %s!";


    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, LogisticsRepository logisticsRepository) {

        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString,
                CommandType.class,String.format(INVALID_COMMAND,commandTypeAsString));


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
                return new CreateLocationCommand(logisticsRepository);
            case ASSIGNPACKAGE:
                return new AssignPackageCommand(logisticsRepository);
            case ASSIGNTRUCK:
                return new AssignTruckCommand(logisticsRepository);
            case SEARCHROUTE:
                return new SearchRouteCommand(logisticsRepository);
            case STARTROUTE:
                return new StartDeliveryRouteCommand(logisticsRepository);
            case HELP:
                return new HelpCommand();
            case SHOWROUTES:
                return new ShowRoutesCommand(logisticsRepository);
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);

        }



    }


}

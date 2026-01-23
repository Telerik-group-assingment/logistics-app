package logisticsapp.core.contracts;

import logisticsapp.commands.contracts.Command;

public interface CommandFactory extends Command{

    Command createCommandFromCommandName(String commandTypeAsString,LogisticsRepository logisticsRepository);

}

package logisticsapp.core;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.CommandFactory;
import logisticsapp.core.contracts.LogisticsRepository;

import java.util.List;

public class CommandFactoryImpl implements CommandFactory {





    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, LogisticsRepository logisticsRepository) {
        return null;
    }

    @Override
    public String execute(List<String> parameters) {
        return "";
    }
}

package logisticsapp.commands.creation;

import logisticsapp.commands.contracts.Command;
import logisticsapp.core.contracts.LogisticsRepository;

import java.util.List;

public class CreateRouteCommand implements Command {



    public CreateRouteCommand(LogisticsRepository repository) {

    }

    @Override
    public String execute(List<String> parameters) {
        return "";
    }
}

package logisticsapp.commands.help;

import logisticsapp.commands.contracts.Command;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public String execute(List<String> parameters) {
        return """
                Available commands:
                
                CREATECUSTOMER <firstName> <lastName> <phone>
                  - Creates a new customer
                
                CREATELOCATION <city>
                  - Creates a new location
                
                CREATEDELIVERYROUTE <city1> <city2> [...cityN]
                  - Creates a delivery route
                
                CREATETRUCK <brand>
                  - Creates a truck
                
                CREATEDELIVERYPACKAGE <weight> <state>
                  - Creates a delivery package
                
                ASSIGNTRUCK <truckId> <routeId>
                  - Assigns a truck to a route
                
                ASSIGNPACKAGE <packageId> <truckId>
                  - Assigns a package to a truck
                
                STARTROUTE <routeId>
                  - Starts the route and calculates arrival times
                
                SEARCHROUTE <startCity> <endCity>
                  - Searches routes by start and end locations
                  
                SHOWROUTES
                - Calls the print methods to every existing route
                
                HELP
                  - Shows all available commands
                """;
    }
}

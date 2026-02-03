package logisticsapp.utils;

import java.util.List;

public class ValidationHelpers {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";

    public static void validateNumberNotNegative(double givenValue, String errorMessage) {
        if (givenValue < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateArgumentsCount(List<String> parameters,int expectedArgumentsCount){
        if(parameters.size() != expectedArgumentsCount){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS,expectedArgumentsCount,parameters.size()));
        }
    }



}

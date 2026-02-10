package logisticsapp.utils;

import java.util.List;

public class ValidationHelpers {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d, Received: %d";

    public static void validateNumberNotNegative(double givenValue, String errorMessage) {
        if (givenValue < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        if (stringToValidate.length() < minLength || stringToValidate.length() > maxLength) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static <E> void validateArgumentsCount(List<E> parameters,int expectedArgumentsCount){
        if(parameters.size() != expectedArgumentsCount){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS,expectedArgumentsCount,parameters.size()));
        }
    }



}

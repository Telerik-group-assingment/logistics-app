package logisticsapp.utils;

public class ValidationHelpers {

    public static void validateNumberNotNegative(double givenValue, String errorMessage) {
        if (givenValue < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

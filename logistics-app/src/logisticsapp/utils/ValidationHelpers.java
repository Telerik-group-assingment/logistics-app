package logisticsapp.utils;

import logisticsapp.exceptions.InvalidInput;
import logisticsapp.models.Location;

public class ValidationHelpers {

    // private static int AVERAGE_SPEED_PER_KM = 87;

    public static void validateNumberNotNegative(double givenValue, String errorMessage) {
        if (givenValue < 0) {
            throw new InvalidInput(errorMessage);
        }
    }

    public static void ValidateLocation(Location starrLocation, Location endLocation, String errorMessage) {
        if (starrLocation.equals(endLocation)) {
            throw new InvalidInput(errorMessage);
        }
    }

    //calculateExpectedTimeBasedOnDistance(Location startLocation, Location endLocation) {
    // Integer distance = getDistance(startlocation.getCity(), endLocation.getCity());
    // Integer travelTimeHours = distance/87;
    // LocalTime expectedArrivalTime = startLocation.getDepartureTime().plusHours(travelTimeHours);;
}

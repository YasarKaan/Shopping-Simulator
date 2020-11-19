package Exceptions;

public class ParkingZoneIsEmptyException extends Exception {
    private String message = "Parking Zone is Empty";

    public ParkingZoneIsEmptyException(){ }

    @Override
    public String getMessage() {
        return message;
    }
}


package Exceptions;

public class HaveNotEnoughProductException extends Exception {
    private String message = "You have not enough product exception";

    public HaveNotEnoughProductException(){}

    public String getMessage() {
        return message;
    }
}

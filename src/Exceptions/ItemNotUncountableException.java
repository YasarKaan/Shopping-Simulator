package Exceptions;

public class ItemNotUncountableException extends ClassCastException {

    private String message = "Item not uncountable";

    public ItemNotUncountableException() {
    }


    public String getMessage() {
        return message;
    }
}
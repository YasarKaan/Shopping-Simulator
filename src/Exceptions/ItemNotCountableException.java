package Exceptions;

public class ItemNotCountableException extends ClassCastException {

    private String message = "Item not countable";

    public ItemNotCountableException() {
    }


    public String getMessage() {
        return message;
    }
}
package Exceptions;

public class DifferentUncountableItemsException extends Exception {
    private String message = "They are different uncountable Items!";

    public DifferentUncountableItemsException(){ }

    @Override
    public String getMessage() {
        return message;
    }
}
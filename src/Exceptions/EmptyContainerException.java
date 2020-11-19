package Exceptions;

public class EmptyContainerException extends Exception {
    private String message = "Container is Empty";
    public EmptyContainerException(){}
    public String getMessage() {
        return message;
    }
}

package Exceptions;

public class EmptyStorageException extends Exception{
    private String message = "Storage/Container is Empty";

    public EmptyStorageException(){}

    public String getMessage() {
        return message;
    }
}

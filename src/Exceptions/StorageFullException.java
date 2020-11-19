package Exceptions;

public class StorageFullException extends Exception {
    private String message = "Storage is Full";

    public StorageFullException() {
    }

    public String getMessage() {
        return message;
    }
}
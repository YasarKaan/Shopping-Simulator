package Exceptions;

public class ContainerAlreadyHereException extends Exception {
    private String message= "Container is here";
    public ContainerAlreadyHereException(){

    }
    @Override
    public String getMessage(){
        return message;
    }
}

package Exceptions;

public class ContainerIsNotHereException extends Exception {
    private String message= "Container is not here";
    public ContainerIsNotHereException(){

    }
    @Override
    public String getMessage(){
        return message;
    }
}

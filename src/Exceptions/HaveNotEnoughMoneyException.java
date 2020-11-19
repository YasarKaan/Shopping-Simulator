package Exceptions;

public class HaveNotEnoughMoneyException extends Exception {
    private String message="You have not enough money";
    public HaveNotEnoughMoneyException(){}

    @Override
    public String getMessage() {
        return message;
    }
}

package Factory;

public class Chocolate extends Products {

    private String name="Chocolate";

    private double amount=0.5;

    @Override
    public String getName() {
        return name;
    }

    public double getAmount(){ return amount;}
}
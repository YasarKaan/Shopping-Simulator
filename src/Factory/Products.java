package Factory;



public abstract class Products {

    private String name;

    private double amount;

    public abstract String getName();

    public double getAmount(){ return amount;}
}
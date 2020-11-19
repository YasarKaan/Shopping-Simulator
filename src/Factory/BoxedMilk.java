package Factory;

public class BoxedMilk extends Products{

    private String name="Boxed Milk";

    private double amount=1;
    @Override
    public String getName() {
        return name;
    }

    public double getAmount(){ return amount;}

}
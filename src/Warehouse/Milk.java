package Warehouse;

import Storage.Liquid;

public class Milk extends Ingredients implements Liquid {
    private String name="Milk";
    private double price;

    public Milk(int Amount){
        super(Amount);
    }

    public double calculateCost(){
        price=getAmount()*0.25;
        return price;
    }

    @Override
    public String getName() {
        return name;
    }


}